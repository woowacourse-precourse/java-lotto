package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class ThousandUnitCheckExceptionTest {
    @Test
    public void unitCheckTest() {
        assertThat(ThousandUnitCheckException.unitCheck(1000)).isEqualTo(1000);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ThousandUnitCheckException.unitCheck(1001));
    }//unitCheckTest
}// end class
