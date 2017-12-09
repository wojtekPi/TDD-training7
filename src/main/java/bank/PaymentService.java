package bank;

public class PaymentService {


    void transferMoney(Account from, Account to, int howMuch) {
        if (from.getAmount() < howMuch) {
            throw new IllegalArgumentException();

        } else {
            from.setAmount(from.amount - howMuch);
            to.setAmount(to.amount + howMuch);
        }
    }
}
