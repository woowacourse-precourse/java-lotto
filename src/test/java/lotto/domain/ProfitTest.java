package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ProfitTest {
    @Test
    void 수익률_계산_테스트1 () {
        Money money = new Money(20000);
        double totalPrize = 23000;

        assertThat(new Profit(money, totalPrize).getProfit())
                .isEqualTo(115.0);
    }

    @Test
    void 수익률_계산_테스트2 () {
        Money money = new Money(9000);
        double totalPrize = 15000;

        assertThat(new Profit(money, totalPrize).getProfit())
                .isEqualTo(166.7);
    }

    @Test
    void 수익률_계산_테스트3 () {
        Money money = new Money(7000);
        double totalPrize = 0;

        assertThat(new Profit(money, totalPrize).getProfit())
                .isEqualTo(0.0);
    }

    @Test
    void 수익률_계산_테스트4 () {
        Money money = new Money(7000);
        double totalPrize = 2000;

        assertThat(new Profit(money, totalPrize).getProfit())
                .isEqualTo(28.6);
    }
}