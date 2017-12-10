package bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    private Object[][] parametersForTestingException() {
        return new Object[][] {
                {-550, 100},
                {-750, 100},
                {-850, 100},
        };
    }

    @Test
    @Parameters(method = "partametersForTestingInInput")
    @TestCaseName("Should return {3} when {4} passed")
    public void shouldReturnSumWhenTwoNumbersPassed(int amountFrom, int amountTo, int amountFromAfter, int
     amountToAfter, int value) {

        bankAccountFrom = new Account(amountFrom, Currency.EUR);
        bankAccountTo = new Account(amountTo, Currency.EUR);

        paymentService.transferMoney(bankAccountFrom, bankAccountTo,);

        assertThat(bankAccountFrom.amount).isEqualTo(amountFromAfter);
        assertThat(bankAccountTo.amount).isEqualTo(amountToAfter);
    }


    @Test
    @Parameters(method = "parametersForTestingException")
    @TestCaseName("Should return IllegalAccessException when {0} passed")
    public void testException(int amountFrom) {



        Instrument instrument = new Instrument(300,);


        assertThatThrownBy(() -> paymentService.transferMoney(bankAccountFrom, bankAccountTo, instrument,))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("I'm very sorry, but you don't have enough money...");
    }



}