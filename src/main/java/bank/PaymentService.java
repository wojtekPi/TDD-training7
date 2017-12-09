package bank;

public class PaymentService {

    void transferMoney(Account from, Account to, int howMuch) {
        from.amount -= howMuch;
        to.amount += howMuch;
    }
}
