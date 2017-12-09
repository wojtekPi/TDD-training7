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
    
    StringCalculator testedObject;

    private Object[][] parametersForTestingTwoNumbersInInput() {
        return new Object[][] {
                {"1,2", 3},
                {"1,0", 1},
                {"2,3,15", 20},
                {"", 0},
                {"1", 1},
        };
    }

    @Before
    public void setUp(){
        testedObject = new StringCalculator();
    }

    @Test
    public void shouldCreateObject() throws Exception {
        assertThat(testedObject).isNotNull();
    }

    @Test
    @Parameters(method = "parametersForTestingTwoNumbersInInput")
    @TestCaseName("Should return {1} when {0} passed")
    public void shouldReturnSumWhenTwoNumbersPassed(String inPut, int value) {

        int result = testedObject.Add(inPut);

        assertThat(result).isEqualTo(value);
    }

}