package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseMoneyTest {

    @DisplayName("로또 구입금이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 로또_구입금이_1000원_미만이도록_생성() {
        assertThatThrownBy(() -> new LottoPurchaseMoney(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또_구입금이_1000원으로_나누어떨어지지_않도록_생성() {
        assertThatThrownBy(() -> new LottoPurchaseMoney(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

}