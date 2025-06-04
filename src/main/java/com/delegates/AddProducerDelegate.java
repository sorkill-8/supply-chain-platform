package com.delegates;

import com.wrappers.Certification;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

public class AddProducerDelegate implements JavaDelegate {

    private static final String USER1_PRIVATE_KEY = "0xed9ebb7bfb97a093f5b48d7aaaad93d4fe8c309283f4f5a0910273f1575fd5bf";
    
    private static final String CONTRACT_ADDRESS = "0x12EAb68ea02CD2805a79167e0FF4aDae54530701";

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        // Acquisizione variabili dal form
        String name = (String) execution.getVariable("name");
        String phoneNo = (String) execution.getVariable("phoneNo");
        String cityState = (String) execution.getVariable("cityState");
        String country = (String) execution.getVariable("country");

        // Connessione alla rete Ethereum simulata
        Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
        Credentials credentials = Credentials.create(USER1_PRIVATE_KEY);
        ContractGasProvider gasProvider = new StaticGasProvider(
                BigInteger.valueOf(20_000_000_000L), // gasPrice
                BigInteger.valueOf(6_721_975)        // gasLimit
        );

        // Caricamento del contratto Certification
        Certification contract = Certification.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);

        try {
            // Chiamata alla funzione addProducer
            TransactionReceipt receipt = contract
                    .addProducer(name, phoneNo, cityState, country)
                    .send();

            if (receipt.isStatusOK()) {
            	System.out.println("╔════════════════════════════════════════════════════════════╗");
                System.out.println("║ ✅ PRODUTTORE REGISTRATO CON SUCCESSO SULLA BLOCKCHAIN   ║");
                System.out.println("╠════════════════════════════════════════════════════════════╣");
                System.out.println("║ ➤ Address Ethereum : " + credentials.getAddress());
                System.out.println("║ ➤ Nome             : " + name);
                System.out.println("║ ➤ Telefono         : " + phoneNo);
                System.out.println("║ ➤ Città/Stato      : " + cityState);
                System.out.println("║ ➤ Paese            : " + country);
                System.out.println("╠════════════════════════════════════════════════════════════╣");
                System.out.println("║ ⚠️  Stato Certificazione : NON ancora certificato.           ");
                System.out.println("║    Attendere validazione da parte dell'amministratore.   ");
                System.out.println("╚════════════════════════════════════════════════════════════╝");
            } else {
                throw new RuntimeException("❌ Transazione fallita a livello di blockchain.");
            }

        } catch (Exception e) {
            System.err.println("⚠️ Errore durante la registrazione del produttore: " + e.getMessage());
            throw new RuntimeException("❌ Fallita la registrazione del produttore sulla blockchain.");
        }
    }
}
