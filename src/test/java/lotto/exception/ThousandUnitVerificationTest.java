package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ThousandUnitVerificationTest {
    @Test
    public void unitVerifyTest() {
        assertThat(ThousandUnitVerification.unitVerify(1000)).isEqualTo(1000);
        assertThat(ThousandUnitVerification.unitVerify(1001));
    }//UnitVerifyTest
}// end class
