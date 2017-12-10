package bank;

public class PaymentService {

    void transferMoney(Account from, Account to, Instrument instrument)  {
        checkCurrencies(from, to, instrument);
        if(from.instrument.amount >= -500) {
            from.instrument.amount -= instrument.amount;
            to.instrument.amount += instrument.amount;
        } else throw new IllegalArgumentException("I'm very sorry, but you don't have enough money...");
    }

    void checkCurrencies(Account from, Account to, Instrument instrument) {
        if(from.instrument.curency == to.instrument.curency &&
                from.instrument.curency == instrument.curency &&
                to.instrument.curency == instrument.curency) return;
        else throw new IllegalArgumentException("I'm very sorry, incorrect currencies...");
    }
}
