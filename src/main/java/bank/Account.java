package bank;

public class Account {
    public int getAmount() {
        return amount;
    }

    public int setAmount(int amount) {
        this.amount = amount;
        return amount;
    }

    int amount;

    public Account(int amount, String id) {
        this.amount = amount;
        this.id = id;
    }

    String id;
}
