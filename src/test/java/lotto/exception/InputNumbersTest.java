package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputNumbersTest {

    @Test
    @DisplayName("숫자가 쉼표로 구분되어 있지 않으면 에러가 발생한다.")
    void checkSeparationByComma() {
        // given
        String numbers = "1,5,32.25,17,19";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> InputNumbers.checkException(numbers));
    }
}
