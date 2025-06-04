package com.delegates;

import com.wrappers.Tracking;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class SetContractParametersDelegate implements JavaDelegate {

    // Chiave privata dell’amministratore
    private static final String PRIVATE_KEY = "0xa2b9c09bf9585b711bc5e482afb8040c26659bdeba6bd6bc16d256690a781160";

    // Indirizzo del contratto Tracking già deployato
    private static final String CONTRACT_ADDRESS = "0x32279D62DaDdADaC73Cd3c72184d88766cE109f5";

    @Override
    public void execute(DelegateExecution execution) {

        try {
            // Recupero variabili dal form Camunda
            Long location1 = (Long) execution.getVariable("location1");
            Long location2 = (Long) execution.getVariable("location2");
            Long leadTime = (Long) execution.getVariable("leadTime");
            Long payment = (Long) execution.getVariable("payment");

            // Connessione al nodo blockchain su Ganache
            Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
            Credentials credentials = Credentials.create(PRIVATE_KEY);

            // Definizione gas provider
            ContractGasProvider gasProvider = new StaticGasProvider(
                    BigInteger.valueOf(20_000_000_000L),
                    BigInteger.valueOf(6721975)
            );

            // Caricamento del contratto Tracking
            Tracking contract = Tracking.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);

            // Conversione coordinate in lista di BigInteger
            List<BigInteger> locations = Arrays.asList(
                    BigInteger.valueOf(location1),
                    BigInteger.valueOf(location2)
            );

            // Invocazione del metodo smart contract per il settaggio dei parametri
            TransactionReceipt receipt = contract
                    .setContractParameters(locations, BigInteger.valueOf(leadTime), BigInteger.valueOf(payment))
                    .send();

            // Verifica dello stato della transazione
            if (receipt.isStatusOK()) {
            	System.out.println("\n");
                System.out.println("╔═══════════════════════════════════════════════════════╗");
                System.out.println("║      ✅ PARAMETRI DEL CONTRATTO SETTATI CON SUCCESSO    ║");
                System.out.println("╠═══════════════════════════════════════════════════════╣");
                System.out.println("║ 🧭 Destinazione attesa  ➤ [" + location1 + ", " + location2 + "]");
                System.out.println("║ ⏱️  Lead Time (sec)     ➤ " + leadTime);
                System.out.println("║ 💰 Token in palio       ➤ " + payment);
                System.out.println("╚═══════════════════════════════════════════════════════╝");
                System.out.println("\n");
            } else {
                System.err.println("❌ Errore: la transazione non è andata a buon fine.");
            }

        } catch (Exception e) {
            System.err.println("❌ Eccezione durante il settaggio dei parametri del contratto:");
            e.printStackTrace();
        }
    }
}
