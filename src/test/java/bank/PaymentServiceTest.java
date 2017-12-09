package bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)

public class PaymentServiceTest {

    PaymentService paymentService;

    @Before
    public void setUp() {
        paymentService = new PaymentService();
    }

    private Object[][] shouldShowUpdatedBalance() {
        return new Object[][] {
                {200, 100, 100},
                {0,20,10}
        };
    }




    @Test
    @Parameters(method = "shouldShowUpdatedBalance")
    public void shouldShowUpdatedTotalAmountInAccount(int initialBalanceAc1,int initialBalanceAc2, int amount ) {
        Account account1 = new Account(initialBalanceAc1, "accountWBK");
        Account account2 = new Account(initialBalanceAc2, "accountDB");
        paymentService.transferMoney(account1,account2, amount);
        assertThat(account1.getAmount()).isEqualTo(initialBalanceAc1-amount);
        assertThat(account2.getAmount()).isEqualTo(initialBalanceAc2+amount);

    }


}

