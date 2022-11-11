package lotto.domain;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {
    @DisplayName("구입한 금액만큼 로또를 반복적으로 발행한다.")
    @Test
    void createLottosForAmountOfMoney() {
        int money = 5000;
        int lottoPrice = 1000;
        Lottos lottos = new Lottos(money);

        assertThat(lottos.countTotal()).isEqualTo(money / lottoPrice);
    }

    @DisplayName("구입 금액은 1,000원 단위로 나누어 떨어져야 한다.")
    @Test
    void createLottosWithIndivisibleMoney() {
        int money = 5100;
        int lottoPrice = 1000;

        assertThatThrownBy(() -> new Lottos(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_LEFT_OVER);

    }
}