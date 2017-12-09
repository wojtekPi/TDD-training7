import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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

    private Object[][] parametersForTestingTwoNumbersInInput(){
        return new Object[][]{
                {"1,2", 3},
                {"1,0", 1},
                {"100,5,10", 115},
        };
    }

    @Test
    @Parameters(method = "parametersForTestingTwoNumbersInInput")
    public void shouldReturnCorrectResultWhenTwoNumberPassed(String input, int expectedOutput){
        int result = testedObject.Add(input);
        assertThat(result).isEqualTo(expectedOutput);
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
    public void shouldReturnOneWhenOnePassed() throws Exception {
        int result = testedObject.Add("1");

        assertThat(result).isEqualTo(1);
    }

    @Test

    public void shouldReturnSumWhenTwoNumbersPassed() {
        int result = testedObject.Add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test

    public void shouldReturnSumOfNumbersPassed(){
        int result = testedObject.Add("2,3,15");

        assertThat(result).isEqualTo(20);
    }
}