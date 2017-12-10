package bank;

public class PaymentService {

    private ExchangeService exchangeService;
    private TransactionDatabase transactionDatabase;

    void transferMoney(Account from, Account to, Instrument instrument)  {
        checkCurrencies(from, to, instrument);
        Instrument moneyToAddToSeccondAccount = instrument;
        if(exchangeService != null) {
            if(to.instrument.curency != instrument.curency) {
                moneyToAddToSeccondAccount = exchangeService.convert(instrument, to.instrument.curency);
            }
        }
        if(from.instrument.amount >= -500) {
            from.instrument.amount -= instrument.amount;
            to.instrument.amount += moneyToAddToSeccondAccount.amount;
            transactionDatabase.save(from, to, moneyToAddToSeccondAccount);
        } else throw new IllegalArgumentException("I'm very sorry, but you don't have enough money...");
    }

    void checkCurrencies(Account from, Account to, Instrument instrument) {
        if(from.instrument.curency == instrument.curency) return;
        else throw new IllegalArgumentException("I'm very sorry, incorrect currencies...");
    }

    public void setExchangeService(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public void setTransactionDatabase(TransactionDatabase transactionDatabase) {
        this.transactionDatabase = transactionDatabase;
    }
}
