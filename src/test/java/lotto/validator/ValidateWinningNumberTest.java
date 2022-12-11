package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateWinningNumberTest {
    ValidateWinningNumber validateWinningNumber;

    @BeforeEach
    void setUp() {
        validateWinningNumber = new ValidateWinningNumber();
    }

    @Test
    void 당첨_번호_테스트() {
        assertDoesNotThrow(() -> validateWinningNumber.validate("1,2,3,4,5,6"));
    }



}