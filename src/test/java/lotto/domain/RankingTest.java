package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void 순위_및_통계_구하기() {
        Ranking ranking = new Ranking(List.of(3, 1, 5, 5, 3), List.of(true, false, true, false, false));
        Assertions.assertEquals(Arrays.asList(Rank.FIFTH, Rank.NONE, Rank.SECOND, Rank.THIRD, Rank.FIFTH),
                ranking.getPlayerRankings());
    }
}