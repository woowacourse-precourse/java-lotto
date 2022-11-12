package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputOverExceptionTest {
    @Test
    void OverCheckTest(){
        assertThat(InputOverException.OverCheck("1,2")).isEqualTo(new String[]{"1","2"});
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputOverException.OverCheck("1,2,3,4,5,6,7"));
    }//OverCheckTest
}// end class
