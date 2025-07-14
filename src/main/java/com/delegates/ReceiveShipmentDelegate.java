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

public class ReceiveShipmentDelegate implements JavaDelegate {

    // Chiave privata del destinatario (user2)
    private static final String USER2_PRIVATE_KEY = "0xdf8a0e8a91f40a2450e57ef9180beef30984f9c5ef425869fbef36efcec13d37";

    // Indirizzo del mittente (user1) usato per verificare il saldo
    private static final String USER1_ADDRESS = "0x8d59bf8B11A96BdCDA008025E025da491EAdAf4B";

    // Indirizzo del contratto Tracking già deployato
    private static final String CONTRACT_ADDRESS = "0xb561AbfF1D8dc5432D7a7b46F3AF6456d5c7B59c";

    @Override
    public void execute(DelegateExecution execution) {
        try {
            // Recupero delle variabili dal form Camunda
            String trackingNo = (String) execution.getVariable("trackingNo");
            String item = (String) execution.getVariable("item");
            Long quantity = (Long) execution.getVariable("quantity");
            Long location1 = (Long) execution.getVariable("location1");
            Long location2 = (Long) execution.getVariable("location2");

            // Connessione alla blockchain
            Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
            Credentials receiverCredentials = Credentials.create(USER2_PRIVATE_KEY);

            ContractGasProvider gasProvider = new StaticGasProvider(
                    BigInteger.valueOf(20_000_000_000L),
                    BigInteger.valueOf(6_721_975));

            // Caricamento del contratto Tracking
            Tracking contract = Tracking.load(CONTRACT_ADDRESS, web3, receiverCredentials, gasProvider);

            List<BigInteger> finalLocation = Arrays.asList(
                    BigInteger.valueOf(location1),
                    BigInteger.valueOf(location2));

            // Esecuzione della funzione receiveShipment del contratto
            TransactionReceipt receipt = contract
                    .receiveShipment(trackingNo, item, BigInteger.valueOf(quantity), finalLocation)
                    .send();

            System.out.println("\n");
            System.out.println("╔════════════════════════════════════════════════════════════╗");
            System.out.println("       ✅ SPEDIZIONE RICEVUTA DAL DESTINATARIO (User2)        ");
            System.out.println("╠════════════════════════════════════════════════════════════╣");
            System.out.println("      📌 Tracking No:     " + trackingNo);
            System.out.println("      🧾 Item:            " + item);
            System.out.println("      🔢 Quantità:        " + quantity);
            System.out.println("      🧭 Posizione:       [" + location1 + ", " + location2 + "]");

            if (receipt.isStatusOK()) {
                System.out.println("╠════════════════════════════════════════════════════════════╣");
                System.out.println("    ✅ La spedizione è stata ricevuta con successo.           ");
            } else {
                System.out.println("╠════════════════════════════════════════════════════════════╣");
                System.out.println("    ❌ La transazione è fallita sulla blockchain.");
            }

        } catch (Exception ex) {
            // Gestione di errori noti: mismatch, tracking errato, ecc.
            System.err.println("❌ Errore durante la ricezione della spedizione:");
            System.err.println("📛 Dettagli: " + ex.getMessage());
            System.err.println(
                    "💡 Possibili cause: quantità errata, nome articolo non corrispondente o trackingNo inesistente.");
        }

        try {
            // Controllo del saldo finale del mittente per validare eventuale pagamento
            Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
            Credentials checkCreds = Credentials.create(USER2_PRIVATE_KEY);
            ContractGasProvider gasProvider = new StaticGasProvider(
                    BigInteger.valueOf(20_000_000_000L),
                    BigInteger.valueOf(6_721_975));

            Tracking contract = Tracking.load(CONTRACT_ADDRESS, web3, checkCreds, gasProvider);
            BigInteger senderBalance = contract.getBalance(USER1_ADDRESS).send();

            System.out.println("💸 Saldo ATTUALE del mittente " + USER1_ADDRESS + ": " + senderBalance + " token");

        } catch (Exception ex) {
            System.err.println("⚠️ Errore nel recupero del saldo del mittente: " + ex.getMessage());
        }
    }
}
