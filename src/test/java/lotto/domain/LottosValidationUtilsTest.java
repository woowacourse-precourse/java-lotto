package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosValidationUtilsTest {

    @DisplayName("구입 금액은 1000으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void validateCanPurchase() {
        assertThatThrownBy(() -> LottosValidationUtils.validateCanPurchase(12345))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
    }
}