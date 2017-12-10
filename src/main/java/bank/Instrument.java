package bank;

public class Instrument {

    int instrument;
    Currency currency;

    public Instrument(int instrument, Currency currency) {

        this.instrument = instrument;
        this.currency = currency;
    }

    public int getInstrument() {
        return instrument;
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


}
