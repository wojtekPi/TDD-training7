public class StringCalculator {

    public int Add(String numbers) {

        int sum = 0;

        for(int i = 0; i < numbers.length(); i++) {
            if(Character.isDigit(numbers.charAt(i))) {
                sum += Integer.parseInt(numbers.charAt(i) + "");
            }
        }
        return sum;
    }


}
