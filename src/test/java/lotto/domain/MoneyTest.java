package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}
