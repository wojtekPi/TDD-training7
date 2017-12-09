import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static final String EMPTY_STRING = "";
    public static final String SEPARATOR = ",";

    public int Add(String numbers) {
       String[] arrayOfNumbers = numbers.split(SEPARATOR);
       int sum = 0;
        if (numbers.equals(EMPTY_STRING)){
            return 0;
        } else {
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                Integer parsedNumber = Integer.valueOf(arrayOfNumbers[i]);
                sum += parsedNumber;
            }
        }
        return sum;
    }
}
