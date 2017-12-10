package bank;

public class PaymentService {

    void transferMoney(Account from, Account to, int howMuch) {
        if(from.amount < -500) {
            throw new IllegalArgumentException("You don't have enough money");}
        from.amount -= howMuch;
        to.amount += howMuch;
    }
}
