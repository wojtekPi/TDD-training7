import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static final String EMPTY_STRING = "";
    public String SEPARATOR = ",";
    public static final String NEWLINE = "\n";

    public int Add(String numbers) {
        // //;1;2

        if(numbers.startsWith("//")){
            String chart =numbers.substring(2,3);
            numbers = numbers.substring(3);
            SEPARATOR = chart;
            System.out.println(chart);
            System.out.println(numbers);
        }

       String[] arrayOfNumbers = numbers.split(SEPARATOR+"|"+NEWLINE);
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
