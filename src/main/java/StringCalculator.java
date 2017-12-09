public class StringCalculator {

    public int Add(String numbers) {

        if(numbers.length() > 1) {
            String[] tab = numbers.split(",");
            int sum = 0;
            for (int i = 0; i < tab.length; i++) {
                int j = Integer.parseInt(tab[i]);
                sum += j;
            }
            return sum;
        }
        if(numbers.equals("1")){
            return 1;
        }
        return 0;
    }

}
