package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberValidatorTest {
    Validator bonusValidator;

    @BeforeEach
    void setUp() {
        bonusValidator = new BonusNumberValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"46","1a","abc"})
    void 보너스번호_유효성_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> bonusValidator.validate(input));
    }

}