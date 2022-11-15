package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @DisplayName("입력금에 따라 로또를 얼마나 살 수 있는지 알 수 있다.")
    @Test
    void getAmount() {
        // given
        int input = 8000;
        int lottoPrice = Config.LOTTO_PRICE;

        // when
        Money money = new Money(input);
        int amount = money.getAmount();

        // then
        assertThat(amount).isEqualTo(input / lottoPrice);
    }

    @DisplayName("입력금이 로또 금액으로 나누어 지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyByNotDivideByLottoPrice() {
        assertThatThrownBy(() -> new Money(800))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("수익률을 계산할 수 있다.")
    @Test
    void getProfitRate() {
        // given
        int money = 8000;
        float profit = 5000f;

        assertThat(new Money(money).getProfitRate(profit)).isEqualTo(profit / money);
    }
}
