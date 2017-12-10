package bank;

public class PaymentService {
    void transferMoney(Account from, Account to, int howMuch)  {
        if(from.amount >= -500) {
            from.amount -= howMuch;
            to.amount += howMuch;
        } else throw new IllegalArgumentException("I'm very sorry, but you don't have enough money...");
    }
}
