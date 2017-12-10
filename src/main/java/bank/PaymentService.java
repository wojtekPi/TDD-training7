package bank;

public class PaymentService {

    private ExchangeService exchangeService;
    private TransferHistory transferHistory;

    void transferMoney(Account from, Account to, Instrument instrument)  {
        checkCurrencies(from, to, instrument);
        Instrument moneyToAddToSeccondAccount = instrument;
        if(exchangeService != null) {
            if(to.instrument.curency != instrument.curency) {
                moneyToAddToSeccondAccount = exchangeService.convert(instrument, to.instrument.curency);
                transferHistory = transferHistory.save(from, to, instrument );
            }
        }
        if(from.instrument.amount >= -500) {
            from.instrument.amount -= instrument.amount;
            to.instrument.amount += moneyToAddToSeccondAccount.amount;
            transferHistory = transferHistory.save(from, to, instrument );
        } else throw new IllegalArgumentException("I'm very sorry, but you don't have enough money...");
    }


    public void setTransferHistory(TransferHistory transferHistory) {
        this.transferHistory = transferHistory;
    }
    void checkCurrencies(Account from, Account to, Instrument instrument) {
        if(from.instrument.curency == instrument.curency) return;
        else throw new IllegalArgumentException("I'm very sorry, incorrect currencies...");
    }

    public void setExchangeService(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public TransferHistory getTransferHistory() {
        return transferHistory;
    }


}
