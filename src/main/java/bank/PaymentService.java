package bank;

public class PaymentService {


    public void transferMoney(Account from, Account to, int howMuch)
    {
//        from = new Account(100, "Ola");
//        to = new Account(30 , "Mieszko");

        from.setAmount(from.getAmount() - howMuch);
        to.setAmount(to.getAmount() + howMuch);

    }

}

