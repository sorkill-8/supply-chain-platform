package com.delegates;

import com.wrappers.Certification;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class CertifyProducerDelegate implements JavaDelegate {

    private static final String ADMIN_PRIVATE_KEY = "0xa2b9c09bf9585b711bc5e482afb8040c26659bdeba6bd6bc16d256690a781160";
    private static final String CERTIFICATION_CONTRACT_ADDRESS = "0x12EAb68ea02CD2805a79167e0FF4aDae54530701";

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String producerAddress = (String) execution.getVariable("producerAddress");

        Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
        Credentials adminCredentials = Credentials.create(ADMIN_PRIVATE_KEY);
        ContractGasProvider gasProvider = new StaticGasProvider(
                BigInteger.valueOf(20_000_000_000L),
                BigInteger.valueOf(6_721_975)
        );

        Certification contract = Certification.load(
                CERTIFICATION_CONTRACT_ADDRESS,
                web3,
                adminCredentials,
                gasProvider
        );

        try {
            TransactionReceipt result = contract.certifyProducer(producerAddress).send();

            if (result.isStatusOK()) {
            	System.out.println("\n");
                System.out.println("╔══════════════════════════════════════════════════════╗");
                System.out.println("║ ✅  CERTIFICAZIONE COMPLETATA CON SUCCESSO           ║");
                System.out.println("╠══════════════════════════════════════════════════════╣");
                System.out.println("║ 👤  Produttore certificato:                          ║");
                System.out.println("║     ➤ Address Ethereum: " + producerAddress);
                System.out.println("║                                                     ║");
                System.out.println("║ ℹ️  Il produttore potrà ora operare sulla piattaforma║");
                System.out.println("╚══════════════════════════════════════════════════════╝");
                System.out.println("\n");
            } else {
                System.err.println("⚠️ Errore: la certificazione non è andata a buon fine.");
            }

        } catch (Exception e) {
            System.err.println("❌ Errore durante la certificazione del produttore: " + e.getMessage());
            throw new RuntimeException("Errore nella chiamata allo smart contract");
        }
    }
}
