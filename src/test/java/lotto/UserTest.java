package lotto;

import lotto.ENUMS.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("로또 구입 금액이 숫자가 아니면 예외 처리")
    void isDegitInput() {
        String input = "1234j";

        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.ERROR_SIGN.getErrorMessage()
                        + " " + ErrorMessages.IS_NOT_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외 처리")
    void divideInput() {
        String input = "20001";

        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.ERROR_SIGN.getErrorMessage()
                        + " " + ErrorMessages.DIVIDE_ERROR.getErrorMessage());
    }
}