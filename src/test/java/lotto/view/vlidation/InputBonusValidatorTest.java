package lotto.view.vlidation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.view.vlidation.InputBonusValidator.validate;
import static org.junit.jupiter.api.Assertions.*;

class InputBonusValidatorTest {


    @DisplayName("정상적인 입력")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"14000", "1", "45", "4000512", "40005120"})
    void normalInputTest(String input) {

        assertDoesNotThrow(() -> validate(input));
    }

    @DisplayName("null or blank 입력")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void validateFirstNumberZeroTest(String input) {
        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate(input));
        // then
        assertEquals("[ERROR] null 이나 빈값이 들어올 수 없습니다.", exception.getMessage());
    }

    @DisplayName("영어 입력")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"a1000", "C10K"})
    void validateIsNumberTest(String input) {
        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate(input));
        // then
        assertEquals("[ERROR] 0~9사이의 숫자로만 이루어진 수를 입력할 수 있습니다.", exception.getMessage());
    }

    @DisplayName("공백 입력")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1 000", " 2000", "50000 "})
    void spaceInputTest(String input) {
        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate(input));
        // then
        assertEquals("[ERROR] 0~9사이의 숫자로만 이루어진 수를 입력할 수 있습니다.", exception.getMessage());
    }

    @DisplayName("0XX 입력(X는 정수를 의미)")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"01", "001", "0111111111"})
    void zeroAtFirstPlaceExistException(String input) {

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate(input));
        // then
        assertEquals("[ERROR] 첫 숫자로 0이 올 수 없습니다.", exception.getMessage());
    }

}