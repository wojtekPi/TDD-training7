public class StringCalculator {

    public int Add(String numbers) {
        if (numbers.equals("1")) {
            return 1;
        }
        if (numbers.equals("")||numbers.equals("0")){
            return 0;
        }

        String[] tempArr = numbers.split(",");

        int[] numbersArr = new int[tempArr.length];

        int result = 0;

        for (int i = 0; i < tempArr.length; i++) {
            numbersArr[i] = Integer.parseInt(tempArr[i]);
            result += numbersArr[i];
        }

        return result;
    }
}
