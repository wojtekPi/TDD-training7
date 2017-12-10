package bank;

public interface TransferHistory {

    TransferHistory save(Account accountFrom, Account accountTo, Instrument transferValue);
}