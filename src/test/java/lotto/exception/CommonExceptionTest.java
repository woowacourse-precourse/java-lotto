package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommonExceptionTest {

    @Test
    @DisplayName("숫자 이외의 값은 에러가 발생한다.")
    void checkInteger() {
        // given
        String inputNumber = "일";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> CommonException.checkInteger(inputNumber));
    }
}
