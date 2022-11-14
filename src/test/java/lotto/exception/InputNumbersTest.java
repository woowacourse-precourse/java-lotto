package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputNumbersTest {
    private final String notSeparatedByCommaMessage = "[ERROR] 당첨번호는 쉼표로 구분되어야 합니다.";


    @Test
    @DisplayName("숫자가 쉼표로 구분되어 있지 않으면 에러가 발생한다.")
    void checkSeparationByComma() {
        // given
        String numbers = "1,5,32.25,17,19";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> InputNumbers.checkException(numbers));
    }

    @Test
    @DisplayName("쉼표로 구분되어 있지 않은 숫자를 입력받아 에러가 발생하면 [ERROR]로 시작하는 메세지를 반환한다.")
    void errorMessageTest1() {
        // given
        String numbers = "41,23_11_9.13,2";

        try {
            // when
            InputNumbers.checkException(numbers);
        } catch (IllegalArgumentException e) {
            // then
            assertThat(e.getMessage()).isEqualTo(notSeparatedByCommaMessage);
        }
    }

    @Test
    @DisplayName("쉼표로 구분되어 있지만 숫자 이외의 값이 포함되어 있으면 에러가 발생한다.")
    void checkInteger() {
        // given
        String numbers = "1,가,2,3,4,5";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> InputNumbers.checkException(numbers));
    }

    @Test
    @DisplayName("쉼표로 구분되어 있고, 모든 값이 숫자이면 에러가 발생하지 않는다.")
    void checkException() {
        // given
        String numbers = "1,2,3,4,5,6";

        // when, then
        assertDoesNotThrow(() -> InputNumbers.checkException(numbers));
    }

    @Test
    @DisplayName("숫자가 6개보다 적으면 에러가 발생한다.")
    void checkNumberCount() {
        String numbers = "1,,,,,";

        assertThrows(IllegalArgumentException.class, () -> InputNumbers.checkException(numbers));
    }
}
