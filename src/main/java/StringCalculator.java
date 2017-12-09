public class StringCalculator {

    public int Add(String numbers) {
        if (numbers.equals("1")) {
            return 1;
        }
        if (numbers.length() > 1) {
            String[] tabNumbers = numbers.split(",");             // tworzę tablicę numerów, ale usuwam z niej ","

            int sumInt = 0;

            for (int i = 0; i < tabNumbers.length; i++) {
                int changeStringToInt = Integer.parseInt(tabNumbers[i]);
                sumInt += changeStringToInt;                                // += daje to samo co sumInt = sumInt + changeStringToInt
            }
            return sumInt;
        }
        return 0;
    }
}