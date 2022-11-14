package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class StatisticsTest {
    Statistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new Statistics();
    }

    @Test
    void 통계_출력_테스트() {
        List<Lotto> quickPicks = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LinkedList<Integer> winningNumWithBonusList = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        int purchaseAmt = 1000;

        statistics.winningStatistics(quickPicks, winningNumWithBonusList, purchaseAmt);
    }

}