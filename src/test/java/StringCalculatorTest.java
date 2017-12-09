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
    public void shouldReturnThreeWhenOneAndTwoPassed() {
        int result = testedObject.Add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void shouldReturnSevenWhenAllNumberAddPassed() {
        int result = testedObject.Add("1,2,3,1");

        assertThat(result).isEqualTo(7);
    }

    @Test
    public void shouldReturnSixWhenAddPassed() {
        int result = testedObject.Add("1\n2,3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldReturnTheeWhenStartWithDelimeterPassed() {
        int result = testedObject.Add("//;\\n1;2");

        assertThat(result).isEqualTo(3);

    }
}