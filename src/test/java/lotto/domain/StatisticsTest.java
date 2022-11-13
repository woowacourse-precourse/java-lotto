package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Test
    void 올바른_순위_구하기() {
        Statistics statistics = new Statistics(List.of(3, 1, 5, 5, 0), List.of(true, false, true, false, false));
        Assertions.assertEquals(Arrays.asList(Rank.FIFTH, Rank.NONE, Rank.SECOND, Rank.THIRD, Rank.NONE),
                statistics.getStatistics());
    }
}