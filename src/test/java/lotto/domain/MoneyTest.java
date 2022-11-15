package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @ParameterizedTest
    @DisplayName("입력값이 1000 이상, 1000으로 나누어떨어지지 않으면 예외가 발생한다.")
    @ValueSource(ints = {11111, -1000, 999, 0})
    void validateInputMoney(int inputMoney) {
        assertThatThrownBy(() -> new Money(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력값이 1000으로 나누어떨어지지 않으면 예외를 던진다.")
    @ValueSource(ints = {18001, 2022})
    void validateDivisibility(int inputMoney) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Money.validateDivisibility(inputMoney);
        }, "예외가 발생하지 않았습니다.");
    }

    @ParameterizedTest
    @DisplayName("입력값이 1000 미만이면 예외를 던진다.")
    @ValueSource(ints = {100, -1500})
    void validateMinimum(int inputMoney) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Money.validateDivisibility(inputMoney);
        }, "예외가 발생하지 않았습니다.");
    }
}