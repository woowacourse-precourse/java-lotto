package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.*;

class StatisticsTest {
    @Test
    void 로또_당첨_결과를_초기화한다() {
        Map<LottoRank, Integer> expected = new TreeMap<>(Collections.reverseOrder());

        expected.put(LottoRank.FIRST, 0);
        expected.put(LottoRank.SECOND, 0);
        expected.put(LottoRank.THIRD, 0);
        expected.put(LottoRank.FOURTH, 0);
        expected.put(LottoRank.FIFTH, 0);
        expected.put(LottoRank.FAIL, 0);

        Map<LottoRank, Integer> result = new TreeMap<>(Collections.reverseOrder());

        Statistics.initializeResult(result);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 당첨_통계를_낸다() {
        List<Integer> winningCount = new ArrayList<>(
                Arrays.asList(3, 4, 4, 0, 2, 5, 5, 6, 1));

        List<Boolean> bonusMatching = new ArrayList<>(
                Arrays.asList(true, true, false, false, false, true, false, false, true));

        Map<LottoRank, Integer> expected = new TreeMap<>(Collections.reverseOrder());

        expected.put(LottoRank.FIRST, 1);
        expected.put(LottoRank.SECOND, 1);
        expected.put(LottoRank.THIRD, 1);
        expected.put(LottoRank.FOURTH, 2);
        expected.put(LottoRank.FIFTH, 1);
        expected.put(LottoRank.FAIL, 3);

        Map<LottoRank, Integer> result = Statistics.makeStatistics(winningCount, bonusMatching);

        assertThat(result).isEqualTo(expected);
    }
}