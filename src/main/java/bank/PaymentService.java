package bank;

public class PaymentService {

    void transferMoney(Account from, Account to, Instrument howMuch) {
        if(from.instrument.amount < -500) {
            throw new IllegalArgumentException("You don't have enough money");}
        if(from.instrument.currency != to.instrument.currency){
            throw new IllegalArgumentException("Wrong currency");}
        if(from.instrument.currency != howMuch.currency){
            throw new IllegalArgumentException("Wrong transfer currency");}
        Instrument transferedValue = new Instrument(howMuch.amount, howMuch.currency);
        from.instrument.amount -= howMuch.amount;
        to.instrument.amount += howMuch.amount;
    }
}
