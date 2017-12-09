import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tdd training on 09.12.17.
 */

public class StringCalculatorTest {

    StringCalculator testedObject;

    @Before
    public void setUp(){
        testedObject = new StringCalculator();
    }

    @Test
    public void shouldCreateObject() throws Exception {
        assertThat(testedObject).isNotNull();
    }

    @Test
    public void shouldReturnZeroWhenEmptyStringPassed() {
        int result = testedObject.Add("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldReturnZerowhenZeroPassed() throws Exception {
        int result = testedObject.Add("0");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldReturnOneWhenOnePassed() throws Exception {
        int result = testedObject.Add("1");

        assertThat(result).isEqualTo(1);
    }
    @Test
    public void shouldReturnThreWhenOneAndTwoPassed() {
        int result = testedObject.Add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test

    public void shouldBeAbleToHandleUnknowAmountOfNumbers() {
        StringBuilder input = new StringBuilder();
        Random random = new Random();
        int iteration = random.nextInt(30)+1;
        int sum = 0;
        for (int i = 0; i < iteration; i++) {
            int number = random.nextInt();
            input.append(number).append(",");
            sum +=number;
        }
        int result = testedObject.Add(input.toString());

        assertThat(result).isEqualTo(sum);
    }
}