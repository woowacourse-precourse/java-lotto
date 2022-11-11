package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("구입한 금액만큼 로또를 반복적으로 발행한다.")
    @Test
    void createLottosForAmountOfMoney() {
        int money = 5000;
        int lottoPrice = 1000;
        Lottos lottos = new Lottos(money);

        assertThat(lottos.countTotal()).isEqualTo(money / lottoPrice);
    }
}