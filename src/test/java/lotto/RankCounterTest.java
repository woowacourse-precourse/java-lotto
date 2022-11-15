package lotto;

import lotto.model.Rank;
import lotto.model.RankCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankCounterTest {
    @DisplayName("순위 계수기 초기 값 테스트")
    @Test
    void createRankCounterTest() {
        RankCounter rankCounter = new RankCounter();

        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            int counter = rankCounter.countRank(rank);
            assertThat(counter).isEqualTo(0);
        }
    }

    @DisplayName("결과 순위를 하나 올리는 테스트")
    @Test
    void addRankTest() {
        RankCounter rankCounter = new RankCounter();

        Rank rank = Rank.FIRST_CLASS;
        int goal = 10;

        for (int count = 0; count < goal; count++) {
            rankCounter.addRank(rank);
        }

        assertThat(rankCounter.countRank(rank)).isEqualTo(goal);
    }
}