package bank;

public interface TransactionStorage {
    void save (Account amountFrom, Account amountTo, Instrument howMuch);
}
