package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class NumberCheckExceptionTest {
    @Test
    public void isNumericTest() {
        assertThat(NumberCheckException.isNumeric("123")).isTrue();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NumberCheckException.isNumeric("abc"));
    }//isNumericTest

    @Test
    public void checkTest() {
        assertThat(NumberCheckException.check("123")).isEqualTo(123);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NumberCheckException.check("abc"));
    }//verifyTest

}// end class
