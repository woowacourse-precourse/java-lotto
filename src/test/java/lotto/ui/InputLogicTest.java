package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputLogicTest {
    @DisplayName("입력된 금액 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3500, 4650, 9080, 10, 100, 1298089, 0})
    void validatePurchaseAmountTest(int money) {
        String errorMessage = "[ERROR] 입력된 금액이 1000원 단위로 나눠 떨어져야 합니다.";
        if (money == 0) {
            errorMessage = "[ERROR] 입력된 금액이 0원보다는 커야 합니다.";
        }
        assertThatThrownBy(() -> InputLogic.validatePurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
}