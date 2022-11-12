package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Buyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {
    @DisplayName("돈이 구매 최소 단위로 안나누어지면 예외가 발생한다.")
    @Test
    void createMoneyByNotUnit() {
        assertThatThrownBy(() -> new Buyer(7500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
