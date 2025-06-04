package com.delegates;

import com.wrappers.Tracking;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.Arrays;

public class AddShipmentDelegate implements JavaDelegate {

    // Chiave privata del mittente (user1)
    private static final String USER1_PRIVATE_KEY = "0xed9ebb7bfb97a093f5b48d7aaaad93d4fe8c309283f4f5a0910273f1575fd5bf";

    // Indirizzo del contratto Tracking già deployato
    private static final String CONTRACT_ADDRESS = "0x32279D62DaDdADaC73Cd3c72184d88766cE109f5";

    @Override
    public void execute(DelegateExecution execution) {
        try {
            // Recupero delle variabili inserite nel form Camunda
            String trackingNo = (String) execution.getVariable("trackingNo");
            String item = (String) execution.getVariable("item");
            Long quantity = (Long) execution.getVariable("quantity");
            Long location1 = (Long) execution.getVariable("location1");

            // Connessione al nodo blockchain
            Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
            Credentials senderCredentials = Credentials.create(USER1_PRIVATE_KEY);
            String senderAddress = senderCredentials.getAddress();

            // Impostazione del gas provider
            ContractGasProvider gasProvider = new StaticGasProvider(
                    BigInteger.valueOf(20_000_000_000L),
                    BigInteger.valueOf(6721975)
            );

            // Caricamento del contratto Tracking
            Tracking contract = Tracking.load(CONTRACT_ADDRESS, web3, senderCredentials, gasProvider);

            // Invio della spedizione sulla blockchain
            var receipt = contract.sendShipment(
                    trackingNo,
                    item,
                    BigInteger.valueOf(quantity),
                    Arrays.asList(BigInteger.valueOf(location1))
            ).send();

            // Verifica dell'esito della transazione
            if (!receipt.isStatusOK()) {
                throw new RuntimeException("❌ Errore durante il salvataggio della spedizione sulla blockchain.");
            }

            // Log dei dati della spedizione
            System.out.println("\n");
            System.out.println("╔════════════════════════════════════════════════════════════╗");
            System.out.println("║           ✅ SPEDIZIONE REGISTRATA CON SUCCESSO            ║");
            System.out.println("╠════════════════════════════════════════════════════════════╣");
            System.out.println("║ 📦 Tracking No:    " + trackingNo);
            System.out.println("║ 📋 Item:           " + item);
            System.out.println("║ 🔢 Quantità:       " + quantity);
            System.out.println("║ 🗺️  LocationData:   [" + location1 + "]");
            System.out.println("║ 👤 Mittente:       " + senderAddress);
            System.out.println("╠════════════════════════════════════════════════════════════╣");

            // Controllo saldo iniziale
            BigInteger balance = contract.getBalance(senderAddress).send();
            System.out.println("║ 💰 Saldo attuale del mittente: " + balance + " token");
            System.out.println("║ 💡 Nota: nessun pagamento ancora ricevuto.               ");
            System.out.println("╚════════════════════════════════════════════════════════════╝");
            System.out.println("\n");

        } catch (Exception e) {
            System.err.println("❌ Errore durante l'esecuzione del delegate AddShipmentDelegate:");
            e.printStackTrace();
        }
    }
}
