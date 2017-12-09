import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tdd training on 09.12.17.
 */

public class StringCalculatorTest {

    StringCalculator testedObject;

    @Before
    public void setUp() {
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
    public void shouldReturnOneWhenOnePassed() throws Exception {
        int result = testedObject.Add("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldReturnSumTwoNumberWhenTwoNumberPassed() {
        int result = testedObject.Add("20,4,2,3,4,5,1,2");

        assertThat(result).isEqualTo(41);


    }
}
   
    