package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.BuyAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyAmountTest {

    @DisplayName("1000으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void createNotDivide() {
        assertThatThrownBy(() -> new BuyAmount("12500")).isInstanceOf(IllegalArgumentException.class);
    }

}
