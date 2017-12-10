package bank;

public interface TransactionStorage {

    void save(Account from, Account to, Instrument instrument);
}
