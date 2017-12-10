package bank;

public class PaymentService {


    public void transferMoney (Account from, Account to, int amount) {
        int valueAc1 = from.getAmount()-amount;
        int valueAc2 =to.getAmount() + amount;

        from.setAmount(valueAc1);
        to.setAmount(valueAc2);



    }


}