package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BuyTest {
    @DisplayName("구입 금액이 1000원으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void buyLottoNotByThousand() {
        String money = "1234";
        Assertions.assertThatThrownBy(() -> Buy.isRightNumber(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

    @DisplayName("5000원 구입 시 5개를 구입한다.")
    @Test
    void buyRightLottoCount() {
        int money = 5000;
        int count = Buy.buyLotto(money);
        Assertions.assertThat(count).isEqualTo(5);
    }
}
