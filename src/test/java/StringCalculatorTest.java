import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tdd training on 09.12.17.
 */

public class StringCalculatorTest {

    @Test
    public void shouldCreateObject() throws Exception {
        StringCalculator testedObject = new StringCalculator();

        int result = testedObject.Add("");
        
        assertThat(testedObject).isNotNull();
    }

    @Test

    public void shouldReturnZeroWhenEmptyStringPassed(){
        StringCalculator testedOject = new StringCalculator ();

        int result = testedOject.Add("");


        assertThat(result).isEqualTo(0);


    }



}