package bank;

public class PaymentService {

    void transferMoney(Account from, Account to, int howMuch) {
        if(from.instrument.amount < -500) {
            throw new IllegalArgumentException("You don't have enough money");}
        if(from.instrument.currency != to.instrument.currency){
            throw new IllegalArgumentException("Wrong currency");}
        from.instrument.amount -= howMuch;
        to.instrument.amount += howMuch;
    }
}
