package bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class PaymentServiceTest {

    private Account account1;
    private Account account2;
    private PaymentService testedObject1;

    @Before
    public void setUp() {
        account1 = new Account(1000, "id1");
        account2 = new Account(2000, "id2");
        testedObject1 = new PaymentService();
    }

    @Test
    public void shouldTransferMoney() {
        int howmuch = 500;
        testedObject1.transferMoney(account1, account2, howmuch);

        assertThat(account1.getAmount()).isEqualTo(500);
        assertThat(account2.getAmount()).isEqualTo(2500);

    }

    @Test(expected = IllegalArgumentException.class)
    public void notEnoughMoneyOnAccountey() {
        int howmuch = 1500;
        testedObject1.transferMoney(account1, account2, howmuch);

        assertThat(account1.getAmount()).isLessThan(1500);
    }
}