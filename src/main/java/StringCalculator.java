public class StringCalculator {

    public int Add(String numbers) {

        String[] numbersArray = numbers.split(",");
        Integer.valueOf(numbers);
        int sum = 0;

        for (int i = 0; i < numbersArray.length; i++) {
            sum +=Integer.valueOf(numbersArray[i]);

        }
        return sum;

//        if (numbers.equals("1")) {
//            return 1;
//        } else if (numbers.equals("1,2")) {
//            return 3;
//        }
//        return 0;
    }
}
