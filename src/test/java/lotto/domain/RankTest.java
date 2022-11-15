package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RankTest {

    @DisplayName("6개 일치 - 1등")
    @Test
    void createRankFirstMatch() {
        assertThat(Rank.FIRST.getMatch())
                .isEqualTo(6);
    }

    @DisplayName("1등이면 상금은 20억이다")
    @Test
    void createRankFirstPrice() {
        assertThat(Rank.FIRST.getPrize().getMoney())
                .isEqualTo(new Money(2000000000).getMoney());
    }

    @DisplayName("0개 일치 - 등수 밖")
    @Test
    void createRankOutMatch() {
        assertThat(Rank.OUT.getMatch())
                .isEqualTo(0);
    }

    @DisplayName("등수 밖이면 상금은 없다")
    @Test
    void createRankOutPrice() {
        assertThat(Rank.OUT.getPrize().getMoney())
                .isEqualTo(new Money(0).getMoney());
    }



}