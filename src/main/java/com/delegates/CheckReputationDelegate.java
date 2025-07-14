package com.delegates;

import com.wrappers.TrustLedger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class CheckReputationDelegate implements JavaDelegate {

    // Chiave privata dell'admin (per firmare la transazione)
    private static final String ADMIN_PRIVATE_KEY = "0xa2b9c09bf9585b711bc5e482afb8040c26659bdeba6bd6bc16d256690a781160";

    // Indirizzo del contratto TrustLedger già deployato
    private static final String TRUSTLEDGER_CONTRACT_ADDRESS = "0xD03615E5328afbB51b5f6953d03f5288D8e87308";

    @Override
    public void execute(DelegateExecution execution) {
        try {
            // Recupero dell'indirizzo del fornitore da controllare (inserito nel form
            // Camunda)
            String supplierAddress = (String) execution.getVariable("supplierAddress");

            if (supplierAddress == null || supplierAddress.isEmpty()) {
                throw new IllegalArgumentException("⚠️ L'indirizzo del fornitore è mancante o nullo.");
            }

            // Inizializzazione della connessione Web3
            Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
            Credentials credentials = Credentials.create(ADMIN_PRIVATE_KEY);

            ContractGasProvider gasProvider = new StaticGasProvider(
                    BigInteger.valueOf(20_000_000_000L),
                    BigInteger.valueOf(6_721_975));

            // Caricamento del contratto TrustLedger
            TrustLedger contract = TrustLedger.load(TRUSTLEDGER_CONTRACT_ADDRESS, web3, credentials, gasProvider);

            // Chiamata alla funzione per verificare la reputazione del fornitore
            BigInteger reputation = contract.checkReputation(supplierAddress).send();

            // Stampa a console della reputazione
            System.out.println("\n");
            System.out.println("╔═════════════════════════════════════════════════════════╗");
            System.out.println("              📈 REPUTAZIONE FORNITORE                     ");
            System.out.println("╠═════════════════════════════════════════════════════════╣");
            System.out.println("      🏷️  Fornitore:        " + supplierAddress);
            System.out.println("      ⭐ Reputazione:       " + reputation + " %");
            System.out.println("╚═════════════════════════════════════════════════════════╝\n");

        } catch (Exception e) {
            System.err.println("❌ Errore durante il controllo della reputazione:");
            System.err.println("📛 Dettagli: " + e.getMessage());
            System.err.println(
                    "💡 Suggerimento: verifica che l'indirizzo del fornitore sia corretto e che il contratto sia accessibile.");
        }
    }
}
