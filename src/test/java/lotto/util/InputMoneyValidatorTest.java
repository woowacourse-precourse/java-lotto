package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.InputMoneyValidator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputMoneyValidatorTest {
    
    @DisplayName("입력 금액이 숫자가 아닌 경우 예외를 발생한다")
    @Test
    void inputMoneyByNonNumber () {
        assertThatThrownBy( () -> validateInputMoney("1000A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 1000원 단위가 아닌 경우 예외를 발생한다.")
    @Test
    void inputMoneyByInvalidUnit () {
        assertThatThrownBy( () -> validateMoneyUnit(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 음수인 경우 예외를 발생한다.")
    @Test
    void inputMoneyByNegativeNumber() {
        assertThatThrownBy( () -> validateMoneyRange(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}