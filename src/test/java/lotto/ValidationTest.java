package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidationTest {

    Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @DisplayName("입력값이 문자를 포함하는지 확인")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"a", "1a", "-"})
    void includeCharacter(String input) {
        try {
            validation.validateNumber(input);
        } catch (IllegalArgumentException e) {
            assertEquals(Errors.NOT_INCLUDE_CHARACTER.toString(), e.getMessage());
        }
    }

    @DisplayName("숫자 범위 확인")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"0", "46", "-1"})
    void outOfRangeNumber(int number) {
        try {
            validation.validateNumberRange(number);
        } catch (IllegalArgumentException e) {
            assertEquals(Errors.OUT_OF_RANGE.toString(), e.getMessage());
        }
    }

}
