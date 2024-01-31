package BankManager;

public class Account {

    private long money;
    private String accNumber;

    private boolean isLocked = false;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
        this.isLocked = false;
    }

    public Account() {
        this.accNumber = accNumber;
        this.money = money;

    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
