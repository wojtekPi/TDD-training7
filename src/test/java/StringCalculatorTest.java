import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
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

    @Before
    public void setUp(){
        testedObject = new StringCalculator();
    }

    private Object[][] parametersForTestingTwoNumberInInput(){
        return new Object[][]{
                {"", 0},
                {"1,0",1 },
                {"2,3,15" , 20}
        };
    }

    @Test
    @Parameters(method = "parametersForTestingTwoNumberInInput" )
    public void shouldReturnCorrectResultWhenTwoNumberPassed(String input ,int expectedOutput){
        int rezult = testedObject.Add(input);

        assertThat(rezult).isEqualTo(expectedOutput);
    }

    @Test
    public void shouldCreateObject() throws Exception {
        assertThat(testedObject).isNotNull();
    }

}