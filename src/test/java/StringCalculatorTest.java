import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)

/**
 * Tdd training on 09.12.17.
 */

public class StringCalculatorTest {

    StringCalculator testedObject;

    @Before
    public void setUp(){
        testedObject = new StringCalculator();
    }

    private Object [][] parametersForTestingTwoNumbersInInput(){
        return new Object[][]{
                {"1,2",3},
                {"1,0",1},
                {"2,3,15",20},
                {"",0},
                {"1\n2,3",6},
                {"//;1;1;1",3},
                {"//v2v1v1",4}
        };
    }

    @Test
    @Parameters(method = "parametersForTestingTwoNumbersInInput")
    @TestCaseName("Should return {1} when {0} passed.")
    public void shouldReturnCorrectResultWhenTwoNumberPassed(String input , int expectedOutput){
        int result = testedObject.Add(input);

        assertThat(result).isEqualTo(expectedOutput);
    }



/*
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
    }*/


}