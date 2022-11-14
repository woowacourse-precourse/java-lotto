package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseAmountTest {
    @DisplayName("로또 구매비용이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void createLotto() {
        assertThatThrownBy(() -> new LottoPurchaseAmount(14500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}