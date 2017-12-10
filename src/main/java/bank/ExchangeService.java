package bank;


public interface ExchangeService {

    Instrument convert(Instrument moneyToConvert, Currencies targetCurrency);
}
