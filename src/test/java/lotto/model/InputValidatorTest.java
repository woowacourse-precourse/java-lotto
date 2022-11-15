package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @DisplayName("금액 입력 시 숫자가 아닌 문자열을 입력할 경우 예외가 발생한다.")
    @Test
    void inputStringNotNumber() {
        assertThatThrownBy(() -> InputValidator.checkMoney("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력 시 양수가 아닌 숫자를 입력할 경우 예외가 발생한다.")
    @Test
    void inputStringNotPositiveNumber() {
        assertThatThrownBy(() -> InputValidator.checkMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력 시 1000으로 나누어 떨어지지 않는 숫자를 입력할 경우 예외가 발생한다.")
    @Test
    void inputStringNotMultiple1000() {
        assertThatThrownBy(() -> InputValidator.checkMoney("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}