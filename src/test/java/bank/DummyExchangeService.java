package bank;

public class DummyExchangeService implements ExchangeService {
    // Don't implement such dummy classes for tests - use mockito instead
    @Override
    public Instrument convert(Instrument moneyToConvert, Currencies targetCurrency) {
        if (targetCurrency == Currencies.EUR){
            return new Instrument(100,Currencies.EUR);
        }
        else return null;
    }
}
