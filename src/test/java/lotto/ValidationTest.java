package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidationTest {

    Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @ParameterizedTest
    @CsvSource({"a", "1a", "-"})
    void 문자가_포함된_입력(String input) {
        try {
            validation.validateNumber(input);
        } catch (IllegalArgumentException e) {
            assertEquals(Errors.NOT_INCLUDE_CHARACTER.toString(), e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({"0", "46", "-1"})
    void 범위를_벗어난_숫자(int number) {
        try {
            validation.validateNumberRange(number);
        } catch (IllegalArgumentException e) {
            assertEquals(Errors.OUT_OF_RANGE.toString(), e.getMessage());
        }
    }

}
