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
    public void setUp() {
        paymentService = new PaymentService();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Object[][] partametersForTestingInInput() {
        return new Object[][]{
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
        Instrument balanceFirst = new Instrument(amountFrom, Currency.PLN);
        Instrument balanceSecond = new Instrument(amountTo, Currency.PLN);
        Instrument transferValue = new Instrument(value, Currency.PLN);
        bankAccountFrom = new Account(balanceFirst);
        bankAccountTo = new Account(balanceSecond);

        paymentService.transferMoney(bankAccountFrom, bankAccountTo, transferValue);

        assertThat(bankAccountFrom.instrument.amount).isEqualTo(amountFromAfter);
        assertThat(bankAccountTo.instrument.amount).isEqualTo(amountToAfter);
    }


    @Test
    public void shouldThrowExecptionWhenBalanaceIsTooSmall() {
        Instrument balanceFirst = new Instrument(-649, Currency.PLN);
        Instrument balanceSecond = new Instrument(1249, Currency.EUR);
        Instrument transferValue = new Instrument(1234, Currency.PLN);
        bankAccountFrom = new Account(balanceFirst);
        bankAccountTo = new Account(balanceSecond);


        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("You don't have enough money");
        paymentService.transferMoney(bankAccountFrom, bankAccountTo, transferValue);
    }

    @Test
    public void shouldThrowExecptionWhenWrongCurrency() {
        Instrument balanceFirst = new Instrument(649, Currency.PLN);
        Instrument balanceSecond = new Instrument(1249, Currency.USD);
        Instrument transferValue = new Instrument(3423, Currency.EUR);
        bankAccountFrom = new Account(balanceFirst);
        bankAccountTo = new Account(balanceSecond);


        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Wrong currency");
        paymentService.transferMoney(bankAccountFrom, bankAccountTo, transferValue);
    }
}