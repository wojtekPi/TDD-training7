package bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class PaymentServiceTest {

    Account bankAccountTo;
    Account bankAccountFrom;
    PaymentService paymentService;

    @Before
    public void setUp(){
        paymentService = new PaymentService();
    }

    private Object[][] partametersForTestingInInput() {
        return new Object[][] {
                {100, 30, 80, 50, 20},
                {0, 10, -50, 60, 50},
                {200, 100, 200, 100, 0},
                {-50, -30, -80, 0, 30},
        };
    }
    


    @Test
    @Parameters(method = "partametersForTestingInInput")
    @TestCaseName("Should return {3} when {4} passed")
    public void shouldReturnSumWhenTwoNumbersPassed(int amountFrom, int amountTo, int amountFromAfter, int
     amountToAfter, int value) {

        bankAccountFrom = new Account(amountFrom);
        bankAccountTo = new Account(amountTo);

        paymentService.transferMoney(bankAccountFrom, bankAccountTo, value);

        assertThat(bankAccountFrom.amount).isEqualTo(amountFromAfter);
        assertThat(bankAccountTo.amount).isEqualTo(amountToAfter);
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void shouldThrowExecptionWhenBalanaceIsTooSmall() {
        ;
        bankAccountFrom = new Account(-600);
        bankAccountTo = new Account(1000);


        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("You don't have enough money");
        paymentService.transferMoney(bankAccountFrom, bankAccountTo, 300);




    }

}