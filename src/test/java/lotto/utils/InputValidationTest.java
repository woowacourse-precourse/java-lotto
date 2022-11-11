package lotto.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    void beforeEach() {
        inputValidation = new InputValidation();
    }

    @DisplayName("입력한 값은 숫자여야만 한다.")
    @Test
    void checkInputIsNumber() {
        String input = "1000a";

        assertThatThrownBy(() -> inputValidation.checkNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 값은 1000원 단위여야 한다.")
    @Test
    void checkInputIsThousand() {
        String input = "1200";

        assertThatThrownBy(() -> inputValidation.checkThousandMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}