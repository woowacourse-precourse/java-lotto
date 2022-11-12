package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ThousandUnitCheckExceptionTest {
    @Test
    public void unitVerifyTest() {
        assertThat(ThousandUnitCheckException.unitCheck(1000)).isEqualTo(1000);
        assertThat(ThousandUnitCheckException.unitCheck(1001));
    }//UnitVerifyTest
}// end class
