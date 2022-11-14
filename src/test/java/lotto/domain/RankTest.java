package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("등수와 당첨 갯수를 잘 매치되는지 확인한다1 .")
    @Test
    void getRankMatchTest1() {
        assertThat(Rank.FIRST.getMatch()).isEqualTo(6);
    }

    @DisplayName("등수와 당첨 갯수를 잘 매치되는지 확인한다 2.")
    @Test
    void getRankMatchTest2() {
        assertThat(Rank.NOTHING.getMatch()).isEqualTo(0);
    }

    @DisplayName("등수와 당첨 갯수를 잘 매치되는지 확인한다 3 . ")
    @Test
    void getRankMatchTest3() {
        assertThat(Rank.SECOND.getMatch()).isEqualTo(5);
    }

    @DisplayName("등수 상금과 실제 금액이 일치하는지 확인한다 1. ")
    @Test
    void getRankPriceTest1() {
        assertThat(Rank.FIRST.getPrice().getMoney())
                .isEqualTo(new Money(2_000_000_000).getMoney());
    }

    @DisplayName("등수 상금과 실제 금액이 일치하는지 확인한다 2. ")
    @Test
    void getRankPriceTest2() {
        assertThat(Rank.SECOND.getPrice().getMoney())
                .isEqualTo(new Money(30_000_000).getMoney());
    }

    @DisplayName("등수 상금과 실제 금액이 일치하는지 확인한다 3. ")
    @Test
    void getRankPriceTest3() {
        assertThat(Rank.NOTHING.getPrice().getMoney())
                .isEqualTo(new Money(0).getMoney());
    }

}