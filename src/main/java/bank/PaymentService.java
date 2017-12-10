package bank;

public class PaymentService {

    void transferMoney(Account from, Account to, Instrument howMuch)  {
        if(from.amount >= -500) {
            Instrument instrument = new Instrument(300, Currency.EUR);

            int temporaryMoney = from.getAmount();
            temporaryMoney = to.getAmount();

        } else throw new IllegalArgumentException("I'm very sorry, but you don't have enough money...");
    }
}
