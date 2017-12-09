import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tdd training on 09.12.17.
 */
@RunWith(JUnitParamsRunner.class)
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

//    @Test
//    public void shouldReturnZeroWhenEmptyStringPassed() {
//        int result = testedObject.Add("");
//
//        assertThat(result).isEqualTo(0);
//    }

//    @Test
//    public void shouldReturnZerowhenZeroPassed() throws Exception {
//        int result = testedObject.Add("0");
//
//        assertThat(result).isEqualTo(0);
//    }

//    @Test
//    public void shouldReturnOneWhenOnePassed() throws Exception {
//        int result = testedObject.Add("1");
//
//        assertThat(result).isEqualTo(1);
//    }

    private Object[][] parametersFortestingTwoNumbersInInput(){
        return new Object[][] {
                {"1,2", 3},
                {"5,6", 11},
                {"0,1", 1},
                {"0", 0},
                {"",0},
                {"1", 1},
                {"10,10", 20}
        };
    }
    @Test
    @Parameters(method = "parametersFortestingTwoNumbersInInput")
    @TestCaseName("Should return {1} when {0} passed")

    public void shouldReturnCorrectResultWhenEmptyStringOneNumberOrMoreNumbersArePassed(String input, int expectedOutput) {
        int result = testedObject.Add(input);

        assertThat(result).isEqualTo(expectedOutput);
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