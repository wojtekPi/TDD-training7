package bank;

public class Account {

    public final int amount;
    public final Currency currency;


    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void instrument(){

        Instrument instrument;
        Currency currency;
    }


    public Account(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
