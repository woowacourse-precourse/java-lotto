package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumberValidatorTest {
    Validator winningValidator;

    @BeforeEach
    void setUp() {
        winningValidator = new WinningNumberValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5","1","123456", "1,2,3,4,5,a"})
    void 당첨번호_유효성_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> winningValidator.validate(input));
    }

}