package BankManager;

public class Main {

    public static void main(String[] args) {
        int accountCount = 100;
        int iterationCount = 10;
        int transferCount = 50;

        Bank bank = new Bank(accountCount, iterationCount, transferCount);

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

    }
}
