package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("6개가 일치하면 1등이다.")
    @Test
    void getRankMatchTest1() {
        assertThat(Rank.FIRST.getMatch()).isEqualTo(6);
    }

    @DisplayName("0개가 일치하지 않으면 아무것도 없다.")
    @Test
    void getRankMatchTest2() {
        assertThat(Rank.NOTHING.getMatch()).isEqualTo(0);
    }


    @DisplayName("1등은 20억의 상금을 받는다")
    @Test
    void getRankPriceTest1() {
        assertThat(Rank.FIRST.getPrice().getMoney())
                .isEqualTo(new Money(2_000_000_000).getMoney());
    }


    @DisplayName("등수에 들지 못하면 상금은 없다.")
    @Test
    void getRankPriceTest3() {
        assertThat(Rank.NOTHING.getPrice().getMoney())
                .isEqualTo(new Money(0).getMoney());
    }

}