package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ValidateTest {

    @Test
    void validMoney() {
    }

    @Test
    void validUserInputMoney() {
    }

    @Test
    void validateUserInput() {
        String testcase = "1,2,3,45, ";
        Validate validate = new Validate();
        assertThatThrownBy(() -> validate.validateUserInput(testcase))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validUserWinningNumber() {
    }
}