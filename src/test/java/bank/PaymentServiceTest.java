package bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static bank.Currencies.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class PaymentServiceTest {

    Account bankAccountTo;
    Account bankAccountFrom;
    PaymentService paymentService;
    Instrument instrument;

    @Before
    public void setUp() {
        paymentService = new PaymentService();
    }

    private Object[][] partametersForTestingInInput() {
        return new Object[][]{
                {100, USD, 30, USD, 80, 50, 20, USD},
                {0, USD, 10, USD, -50, 60, 50, USD},
                {200, USD, 100, USD, 200, 100, 0, USD},
                {-50, USD, -30, USD, -80, 0, 30, USD},
        };
    }

    private Object[][] parametersForTestingException() {
        return new Object[][]{
                {-550, USD, 100, USD},
                {-750, USD, 100, USD},
                {-850, USD, 100, USD},
        };
    }

    private Object[][] parametersForTestingCurrenciesException() {
        return new Object[][]{
                {550, EUR, 200, USD, 100, USD},
                {850, PLN, 80, PLN, 100, USD},
        };
    }

    @Test
    @Parameters(method = "partametersForTestingInInput")
    @TestCaseName("Should return {3} when {4} passed")
    public void shouldReturnSumWhenTwoNumbersPassed(int amountFrom, Currencies currenciesFrom, int amountTo,
                                                    Currencies currenciesTo, int amountFromAfter, int amountToAfter,
                                                    int howMuch, Currencies currencies) {

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

    @Test
    public void shouldCallExchengeServiceWhenDifferentCurrencyInToAccount() {
        // old way of testing - don't do that - use Mockito instead
        ExchangeService exchangeService = new DummyExchangeService();
        paymentService.setExchangeService(exchangeService);

        Account from = new Account(new Instrument(600, PLN));
        Account to = new Account(new Instrument(50, EUR));
        paymentService.transferMoney(from,
                to,
                new Instrument(400, PLN));

        assertThat(from.instrument.amount).isEqualTo(200);
        assertThat(from.instrument.curency).isEqualTo(PLN);
        assertThat(to.instrument.amount).isEqualTo(150);
        assertThat(to.instrument.curency).isEqualTo(EUR);
    }

    @Test
    public void shouldCallExchengeServiceWhenDifferentCurrencyInToAccountUsingMockito() {
        ExchangeService exchangeService = mock(ExchangeService.class);
        paymentService.setExchangeService(exchangeService);

        Instrument instrumentFrom = new Instrument(600, PLN);
        Instrument instrumentToTransfer = new Instrument(400, PLN);
        Account from = new Account(instrumentFrom);
        Account to = new Account(new Instrument(50, EUR));

        when(exchangeService.convert(instrumentToTransfer, EUR))//dla jednej waluty
                .thenReturn(new Instrument(100, EUR));

        paymentService.transferMoney(from, to, instrumentToTransfer);

        assertThat(from.instrument.amount).isEqualTo(200);
        assertThat(from.instrument.curency).isEqualTo(PLN);
        assertThat(to.instrument.amount).isEqualTo(150);
        assertThat(to.instrument.curency).isEqualTo(EUR);
        verify(exchangeService, times(1)).convert(instrumentToTransfer, EUR);
    }

    @Test
    public void shouldCallExchengeServiceWhenDifferentCurrencyInToAccountUsingMockito2() {
        ExchangeService exchangeService = mock(ExchangeService.class);
        paymentService.setExchangeService(exchangeService);

        Instrument instrumentFrom1 = new Instrument(600, PLN);
        Instrument instrumentToTransfer1 = new Instrument(200, PLN);
        Account from1 = new Account(instrumentFrom1);
        Account to1 = new Account(new Instrument(50, EUR));

        when(exchangeService.convert(eq(instrumentToTransfer1), any(Currencies.class)))//dla wszystkich walut
                .thenReturn(new Instrument(50, EUR));

        paymentService.transferMoney(from1, to1, instrumentToTransfer1);

        assertThat(from1.instrument.amount).isEqualTo(400);
        assertThat(from1.instrument.curency).isEqualTo(PLN);
        assertThat(to1.instrument.amount).isEqualTo(100);
        assertThat(to1.instrument.curency).isEqualTo(EUR);

        verify(exchangeService, times(1)).convert(instrumentToTransfer1, EUR);
    }

    @Test
    public void shouldThrowExceptionWhenTransactionStorageIsFailed() {
        TransactionStorage transactionStorage = mock(TransactionStorage.class);
        paymentService.setTransactionStorage(transactionStorage);

        Instrument instrument = new Instrument(600, PLN);
        Account from = new Account(new Instrument(600, PLN));
        Account to = new Account(new Instrument(50, EUR));

        paymentService.transferMoney(from, to, instrument);
        verify(transactionStorage, times(1)).save(from, to, instrument);

    }
}