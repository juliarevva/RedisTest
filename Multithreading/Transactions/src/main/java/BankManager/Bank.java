package BankManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank implements Runnable {

    private Map<String, Account> accounts = new HashMap<>();
    private int accountCount = 0;
    private int iterationCount = 0;
    private int transferCount = 0;
    private final Random random = new Random();

    public Bank(int accountsCount, int iterationCount, int transferCount) {
        this.accountCount = accountsCount;
        this.iterationCount = iterationCount;
        this.transferCount = transferCount;
        addAccounts(accountsCount);
    }

    public void addAccounts (int accountsCount) {
        for(int i = 1; i <= accountCount; i++) {
            Account account = new Account(String.valueOf(i), (long) i * 100000);
            accounts.put(account.getAccNumber(), account);
        }
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        synchronized (fromAccountNum.compareTo(toAccountNum) > 0 ? fromAccountNum : this) {

            if(amount > fromAccount.getMoney()) {

            } else if(fromAccount.isLocked() || toAccount.isLocked()) {

            } else if(amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)) {
                fromAccount.setLocked(true);
                toAccount.setLocked(true);

            } else {
                fromAccount.setMoney(fromAccount.getMoney() - amount);
                toAccount.setMoney(toAccount.getMoney() + amount);
            }
        }
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for(Map.Entry<String, Account> entry : accounts.entrySet()) {
            long accountMoney = entry.getValue().getMoney();
            sum += accountMoney;
        }
        return sum;
    }

    public int getAccountsSize() {
        return accounts.size();
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public int getIterationCount() {
        return iterationCount;
    }

    public int getTransferCount() {
        return transferCount;
    }

    @Override
    public void run() {
        String randomAccountFrom = String.valueOf((int) (1 + (Math.random() * getAccountsSize())));
        String randomAccountTo = String.valueOf((int) (1 + (Math.random() * getAccountsSize())));
        long randomAmount = (long) (Math.random() * 10) * 10000;

        try {
            transfer(randomAccountFrom, randomAccountTo, randomAmount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
