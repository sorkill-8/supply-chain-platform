package com.delegates;

import com.wrappers.Certification;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class FindProducerDelegate implements JavaDelegate {

    private static final String ADMIN_PRIVATE_KEY = "0xa2b9c09bf9585b711bc5e482afb8040c26659bdeba6bd6bc16d256690a781160";
    private static final String CONTRACT_ADDRESS = "0x12EAb68ea02CD2805a79167e0FF4aDae54530701";

    @Override
    public void execute(DelegateExecution execution) {
        try {
            // Recupero address dal form
            String producerAddress = (String) execution.getVariable("producerAddress");

            // Connessione alla rete locale Ethereum (Ganache)
            Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
            Credentials credentials = Credentials.create(ADMIN_PRIVATE_KEY);
            ContractGasProvider gasProvider = new StaticGasProvider(
                    BigInteger.valueOf(20_000_000_000L),
                    BigInteger.valueOf(6_721_975)
            );

            // Caricamento del contratto Certification
            Certification contract = Certification.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);

            // Recupero delle informazioni dal contratto
            var producerInfo = contract.findProducer(producerAddress).send();

            String name = producerInfo.component1();
            String phoneNo = producerInfo.component2();
            String cityState = producerInfo.component3();
            String country = producerInfo.component4();
            Boolean certified = producerInfo.component5();

            // Stampa dei dati
            System.out.println("\n");
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║        ℹ️  DATI PRODUTTORE RECUPERATI              ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            System.out.println("║ 🆔 Address        ➤ " + producerAddress);
            System.out.println("║ 📛 Nome           ➤ " + name);
            System.out.println("║ ☎️ Telefono        ➤ " + phoneNo);
            System.out.println("║ 🏙️  Città/Stato    ➤ " + cityState);
            System.out.println("║ 🌍 Paese          ➤ " + country);
            System.out.println("║ 📄 Certificato    ➤ " + (certified ? "✅ Sì" : "❌ No"));
            System.out.println("╚════════════════════════════════════════════════════╝");
            System.out.println("\n");

        } catch (Exception e) {
            System.err.println("❌ Errore durante il recupero delle informazioni del produttore: " + e.getMessage());
            throw new RuntimeException("Errore durante il recupero del produttore", e);
        }
    }
}
