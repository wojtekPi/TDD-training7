import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tdd training on 09.12.17.
 */
@RunWith(JUnitParamsRunner.class)
public class StringCalculatorTest {

    private StringCalculator testedObject;

    @Before
    public void setUp(){
        testedObject = new StringCalculator();
    }

//    @Test
//    public void shouldCreateObject() throws Exception {
//        assertThat(testedObject).isNotNull();
//    }
//
//    @Test
//    public void shouldReturnZeroWhenEmptyStringPassed() {
//        int result = testedObject.Add("");
//
//        assertThat(result).isEqualTo(0);
//    }
//
//    @Test
//    public void shouldReturnOneWhenOnePassed() throws Exception {
//        int result = testedObject.Add("1");
//
//        assertThat(result).isEqualTo(1);
//    }
//
//    @Test
//    public void shouldReturnSumWhenTwoNumbersPassed() {
//        int result = testedObject.Add("1,2");
//
//        assertThat(result).isEqualTo(3);
//    }
//
//    @Test
//
//    public void shouldReturnSumOfNumbersPassed(){
//        int result = testedObject.Add("2,3,15");
//
//        assertThat(result).isEqualTo(20);
//    }

    private Object[][] parametersForTestingAnyNumbersInInput(){
        return new Object[][]{
                {"0,1", 1},
                {"1,2", 3},
                {"2,3", 5},
                {"2,3,15", 20}
        };
    }

    @Test
    @Parameters(method = "parametersForTestingAnyNumbersInInput")
    @TestCaseName("Should return {1} when {0} passed. ")
    public void shouldReturnCorrectResultWhenTwoNumberPassed(String input, int expectedOutput) {
        int result = testedObject.Add(input);

        assertThat(result).isEqualTo(expectedOutput);
    }
}