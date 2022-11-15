package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeMoneyTest {
    @DisplayName("정확한 상금을 가지고 오는지 확인한다")
    @Test
    void getPrizeMoneyTest() {
        assertThat(new PrizeMoney(new Money(8_000), 5_000).getProfit()).isEqualTo(62.5);
    }

}