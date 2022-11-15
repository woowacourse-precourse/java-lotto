package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseMoneyTest {
    @DisplayName("로또 구입 금액이 1,000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoPurchaseMoneyByInvalidNumber() {
        assertThatThrownBy(() -> new LottoPurchaseMoney(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}