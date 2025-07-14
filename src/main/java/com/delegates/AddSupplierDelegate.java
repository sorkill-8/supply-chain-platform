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

public class AddSupplierDelegate implements JavaDelegate {

    // Chiave privata dell'admin (chi firma la transazione)
    private static final String ADMIN_PRIVATE_KEY = "0xa2b9c09bf9585b711bc5e482afb8040c26659bdeba6bd6bc16d256690a781160";

    // Indirizzo Ethereum del fornitore da registrare (user1)
    private static final String USER1_ADDRESS = "0x8d59bf8B11A96BdCDA008025E025da491EAdAf4B";

    // Indirizzo del contratto TrustLedger già deployato
    private static final String CONTRACT_ADDRESS = "0xD03615E5328afbB51b5f6953d03f5288D8e87308";

    @Override
    public void execute(DelegateExecution execution) {
        try {
            // Recupero delle variabili dal form BPMN
            String name = (String) execution.getVariable("name");
            String phoneNo = (String) execution.getVariable("phoneNo");
            String cityState = (String) execution.getVariable("cityState");
            String country = (String) execution.getVariable("country");
            String goodsType = (String) execution.getVariable("goodsType");

            // Connessione alla rete Ethereum (Ganache)
            Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
            Credentials credentials = Credentials.create(ADMIN_PRIVATE_KEY);

            ContractGasProvider gasProvider = new StaticGasProvider(
                    BigInteger.valueOf(20_000_000_000L),
                    BigInteger.valueOf(6_721_975));

            // Caricamento del contratto TrustLedger
            TrustLedger contract = TrustLedger.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);

            // Invocazione della funzione per aggiungere un fornitore
            var receipt = contract.addSupplier(name, phoneNo, cityState, country, goodsType).send();

            if (!receipt.isStatusOK()) {
                throw new RuntimeException("❌ Errore durante la registrazione del fornitore sulla blockchain.");
            }

            System.out.println("\n");
            System.out.println("╔════════════════════════════════════════════════════════════╗");
            System.out.println("          ✅ FORNITORE REGISTRATO CON SUCCESSO               ");
            System.out.println("╠════════════════════════════════════════════════════════════╣");
            System.out.println("     👤 Address:       " + USER1_ADDRESS);
            System.out.println("     📛 Nome:          " + name);
            System.out.println("     📞 Telefono:      " + phoneNo);
            System.out.println("     🌍 Città/Stato:   " + cityState);
            System.out.println("     🗺️  Paese:         " + country);
            System.out.println("     📦 Tipo Beni:     " + goodsType);
            System.out.println("╚════════════════════════════════════════════════════════════╝");
            System.out.println("\n");

        } catch (Exception e) {
            System.err.println("⚠️ Errore nell'aggiunta del fornitore: " + e.getMessage());
            System.err.println("💡 Verifica i parametri e il collegamento al contratto TrustLedger.");
        }
    }
}
