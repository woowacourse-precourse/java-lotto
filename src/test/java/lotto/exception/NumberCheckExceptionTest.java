package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class NumberCheckExceptionTest {
    @Test
    public void isNumericTest() {
        assertThat(NumberCheckException.isNumeric("123")).isTrue();
        assertThat(NumberCheckException.isNumeric("asd")).isFalse();
    }//isNumericTest

    @Test
    public void verifyTest() {
        assertThat(NumberCheckException.check("123")).isEqualTo(123);
        assertThat(NumberCheckException.check("asd"));
    }//verifyTest

}// end class
