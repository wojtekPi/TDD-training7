public class StringCalculator {

    public int Add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        } else if (numbers.equals("1")) {
            return 1;
        }

        int sum = 0;
        String[] data = numbers.split(",|\\n");

        for (int i = 0; i < data.length ; i++) {
            sum+= Integer.parseInt(data[i]);
        }

        return sum;
    }
}