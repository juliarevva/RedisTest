package BankManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBank {

    Bank bank;

    @BeforeEach
    public void initialize() {
        int accountCount = 100;
        int iterationCount = 10;
        int transferCount = 50;
        bank = new Bank(accountCount, iterationCount, transferCount);
    }

    @Test
    @DisplayName("Test Get Sum All Accounts")
    public void testGetSumAllAccounts() {
        long sumAllAccounts = 0;
        for (Map.Entry<String, Account> entry : bank.getAccounts().entrySet()) {
            sumAllAccounts += entry.getValue().getMoney();
        }
        assertEquals(sumAllAccounts, bank.getSumAllAccounts());
    }

    @Test
    @DisplayName("Test Transfer")
    public void testTransfer() {

        long sumAllAccountsBefore = bank.getSumAllAccounts();

        Thread newBank = new Thread(() -> {
            for (int i = 1; i <= bank.getIterationCount(); i++) {
                for (int j = 1; j <= bank.getTransferCount(); j++) {
                    Thread thread = new Thread(bank);
                    thread.start();

                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        newBank.start();

        try {
            newBank.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long sumAllAccountsAfter = bank.getSumAllAccounts();
        assertEquals(sumAllAccountsBefore, sumAllAccountsAfter);
    }
}
