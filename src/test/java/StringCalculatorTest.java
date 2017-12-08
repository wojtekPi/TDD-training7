import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tdd training on 09.12.17.
 */

public class StringCalculatorTest {

    @Test
    public void shouldCreateObject() throws Exception {
        StringCalculator testedObject = new StringCalculator();
        assertThat(testedObject).isNotNull();
        assertThat(testedObject.Add("")).isEqualTo(1);
    }

}