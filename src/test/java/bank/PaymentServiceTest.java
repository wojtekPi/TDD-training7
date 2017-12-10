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
    Instrument instrument;

    @Before
    public void setUp(){
        paymentService = new PaymentService();
    }

    private Object[][] partametersForTestingInInput() {
        return new Object[][] {
                {100, Currencies.USD, 30, Currencies.USD, 80, 50, 20, Currencies.USD},
                {0, Currencies.USD, 10, Currencies.USD, -50, 60, 50, Currencies.USD},
                {200, Currencies.USD, 100, Currencies.USD, 200, 100, 0, Currencies.USD},
                {-50, Currencies.USD, -30, Currencies.USD, -80, 0, 30, Currencies.USD},
        };
    }

    private Object[][] parametersForTestingException() {
        return new Object[][] {
                {-550, Currencies.USD, 100, Currencies.USD},
                {-750, Currencies.USD, 100, Currencies.USD},
                {-850, Currencies.USD, 100, Currencies.USD},
        };
    }

    private Object[][] parametersForTestingCurrenciesException() {
        return new Object[][] {
                {550, Currencies.EUR, 200, Currencies.USD, 100, Currencies.USD},
                {750, Currencies.USD, 120, Currencies.PLN, 100, Currencies.USD},
                {850, Currencies.PLN, 80, Currencies.PLN, 100, Currencies.USD},
        };
    }

    @Test
    @Parameters(method = "partametersForTestingInInput")
    @TestCaseName("Should return {3} when {4} passed")
    public void shouldReturnSumWhenTwoNumbersPassed(int amountFrom, Currencies currenciesFrom, int amountTo,
                                                    Currencies currenciesTo, int amountFromAfter, int amountToAfter, int howMuch, Currencies currencies) {

        instrument = new Instrument(howMuch, currencies);
        bankAccountFrom = new Account(new Instrument(amountFrom, currenciesFrom));
        bankAccountTo = new Account(new Instrument(amountTo, currenciesTo));

        paymentService.transferMoney(bankAccountFrom, bankAccountTo, instrument);

        assertThat(bankAccountFrom.instrument.amount).isEqualTo(amountFromAfter);
        assertThat(bankAccountTo.instrument.amount).isEqualTo(amountToAfter);
    }

    @Test
    @Parameters(method = "parametersForTestingException")
    @TestCaseName("Should return IllegalAccessException when {0} passed")
    public void testException(int amountFrom, Currencies currenciesFrom, int howMuch, Currencies currencies) {

        instrument = new Instrument(howMuch, currencies);
        bankAccountFrom = new Account(new Instrument(amountFrom, currenciesFrom));
        bankAccountTo = new Account(new Instrument(0, currenciesFrom));

        assertThatThrownBy(() -> paymentService.transferMoney(bankAccountFrom, bankAccountTo, instrument))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("I'm very sorry, but you don't have enough money...");
    }

    @Test
    @Parameters(method = "parametersForTestingCurrenciesException")
    @TestCaseName("Should return IllegalAccessException when {0} passed")
    public void testCurrenciesException(int amountFrom, Currencies currenciesFrom, int amountTo,
                                        Currencies currenciesTo, int howMuch, Currencies currencies) {

        instrument = new Instrument(howMuch, currencies);
        bankAccountFrom = new Account(new Instrument(amountFrom, currenciesFrom));
        bankAccountTo = new Account(new Instrument(amountTo, currenciesTo));

        assertThatThrownBy(() -> paymentService.checkCurrencies(bankAccountFrom, bankAccountTo, instrument))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("I'm very sorry, incorrect currencies...");
    }
}