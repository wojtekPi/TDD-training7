import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int Add(String numbers) {

       String[] myNumbers = numbers.split(",");
       int sum = 0;

        if(numbers.equals("1")){
            return 1;
        } else if (numbers.equals("")){
            return 0;
        } else {
            for (int i = 0; i < myNumbers.length; i++) {
                Integer parsedNumber = Integer.valueOf(myNumbers[i]);
                sum += parsedNumber;
            }
        }
        return sum;
    }
}
