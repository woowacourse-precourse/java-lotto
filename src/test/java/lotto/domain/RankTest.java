package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void of_테스트_6개_모두_맞춤() {
        Rank rank = Rank.makeRank(6, false);
        assertThat(rank).isEqualTo(Rank.SIX);
    }

    @Test
    void of_테스트_5개_맞춤_보너스_없이() {
        Rank rank = Rank.makeRank(5, false);
        assertThat(rank).isEqualTo(Rank.FIVE);
    }

    @Test
    void of_테스트_5개_맞춤_보너스_있음() {
        Rank rank = Rank.makeRank(5, true);
        assertThat(rank).isEqualTo(Rank.FIVEWITHBONUS);
    }

    @Test
    void of_테스트_4개_맞춤() {
        Rank rank = Rank.makeRank(4, false);
        assertThat(rank).isEqualTo(Rank.FOUR);
    }

    @Test
    void of_테스트_3개_맞춤() {
        Rank rank = Rank.makeRank(3, false);
        assertThat(rank).isEqualTo(Rank.THREE);
    }

    @Test
    void of_테스트_맞춘거_없음() {
        Rank rank = Rank.makeRank(0, false);
        assertThat(rank).isEqualTo(Rank.ZERO);
    }


}
