package bank;

public interface TransactionDatabase {

    void save(Account from, Account to, Instrument instrument);
}
