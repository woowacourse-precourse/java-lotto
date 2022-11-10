package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExceptionTest {

    @Test
    void validMoney() {
    }

    @Test
    void validUserInputMoney() {
    }

    @Test
    void validUserInputStringNumber() {
        String testcase = "1,2,3,45";
        Exception exception = new Exception();
        assertThatThrownBy(() -> exception.validUserInputStringNumber(testcase))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validUserWinningNumber() {
    }
}