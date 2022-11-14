package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommonExceptionTest {
    private final String notIntMessage = "[ERROR] 숫자를 입력해야 합니다.";
    private final String outOfRangeMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    @Test
    @DisplayName("숫자 이외의 값은 에러가 발생한다.")
    void checkInteger() {
        // given
        String inputNumber = "일";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> CommonException.checkInteger(inputNumber));
    }

    @Test
    @DisplayName("숫자 이외의 값을 받아 에러가 발생하면 [ERROR]로 시작하는 메세지를 반환한다.")
    void errorMessageTest1() {
        // given
        String inputNumber = "일";

        try {
            // when
            CommonException.checkInteger(inputNumber);
        } catch (IllegalArgumentException e) {
            // then
            assertThat(e.getMessage()).isEqualTo(notIntMessage);
        }
    }

    @Test
    @DisplayName("1 ~ 45 범위를 벗어나는 값은 에러가 발생한다.")
    void checkNumberRange1() {
        // given
        int number = 46;

        // when, then
        assertThrows(IllegalArgumentException.class, () -> CommonException.checkNumberRange(number));
    }

    @Test
    @DisplayName("1 ~ 45 범위 이내의 값은 에러가 발생하지 않는다.")
    void checkNumberRange2() {
        // given
        int number = 45;

        // when, then
        assertDoesNotThrow(() -> CommonException.checkNumberRange(number));
    }

    @Test
    @DisplayName("1 ~ 45 범위를 벗어나는 값을 받아 에러가 발생하면 [ERROR]로 시작하는 메세지를 반환한다.")
    void errorMessageTest2() {
        // given
        int number = 46;

        try {
            // when
            CommonException.checkNumberRange(number);
        } catch (IllegalArgumentException e) {
            // then
            assertThat(e.getMessage()).isEqualTo(outOfRangeMessage);
        }
    }
}
