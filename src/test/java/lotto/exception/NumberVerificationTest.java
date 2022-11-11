package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class NumberVerificationTest {
    @Test
    public void isNumericTest() {
        assertThat(NumberVerification.isNumeric("123")).isTrue();
        assertThat(NumberVerification.isNumeric("asd")).isFalse();
    }//isNumericTest

    @Test
    public void verifyTest() {
        assertThat(NumberVerification.verify("123")).isEqualTo(123);
        assertThat(NumberVerification.verify("asd"));
    }//verifyTest

}// end class
