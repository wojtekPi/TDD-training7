import static java.lang.Integer.valueOf;

public class StringCalculator {

    public int Add(String numbers) {

        if (numbers.equals("")) {
            return 0;
        }else {
            //Zamieniamy poczatkowego Stringa, na tablice pojedynczych stringow reprezentujacych cyfry
        String[] nameOfNumbers = numbers.split(",");
        int result = 0;
        for (int i = 0; i < nameOfNumbers.length ; i++) {

            //rzutujemy pojedyncze stringi z tablicy na inty
            int number = Integer.valueOf(nameOfNumbers[i]);

            //sumujemy
            result = result + number;
        }
        return result;
        }
    }
}
