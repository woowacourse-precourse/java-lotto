package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class LottoRankingResultsTest {
    @DisplayName("5등 1개 당첨")
    @Test
    void recordRanking_1FIFTH() {
        LottoRankingResults lottoRankingResults = new LottoRankingResults();

        lottoRankingResults.recordTheRanking(Ranking.FIFTH);

        Map<Ranking, Integer> rankingResults = lottoRankingResults.getRankingResults();
        Map<Ranking, Integer> result = Map.of(Ranking.FIFTH, 1,
                Ranking.FOURTH, 0,
                Ranking.THRID, 0,
                Ranking.SECOND, 0,
                Ranking.FIRST, 0);

        Assertions.assertThat(rankingResults).isEqualTo(result);

    }

    @DisplayName("4등 3개, 2등 1개 당첨")
    @Test
    void recordRanking_3FOURTH_1SECOND() {
        LottoRankingResults lottoRankingResults = new LottoRankingResults();

        lottoRankingResults.recordTheRanking(Ranking.FOURTH);
        lottoRankingResults.recordTheRanking(Ranking.SECOND);
        lottoRankingResults.recordTheRanking(Ranking.FOURTH);
        lottoRankingResults.recordTheRanking(Ranking.FOURTH);

        Map<Ranking, Integer> rankingResults = lottoRankingResults.getRankingResults();
        Map<Ranking, Integer> result = Map.of(Ranking.FIFTH, 0,
                Ranking.FOURTH, 3,
                Ranking.THRID, 0,
                Ranking.SECOND, 1,
                Ranking.FIRST, 0);

        Assertions.assertThat(rankingResults).isEqualTo(result);
    }

    @DisplayName("3등 1개, 2등 2개, 1등 1개 당첨")
    @Test
    void recordRanking_1THRID_2SECOND_1FIRST() {
        LottoRankingResults lottoRankingResults = new LottoRankingResults();

        lottoRankingResults.recordTheRanking(Ranking.THRID);
        lottoRankingResults.recordTheRanking(Ranking.SECOND);
        lottoRankingResults.recordTheRanking(Ranking.FIRST);
        lottoRankingResults.recordTheRanking(Ranking.SECOND);

        Map<Ranking, Integer> rankingResults = lottoRankingResults.getRankingResults();
        Map<Ranking, Integer> result = Map.of(Ranking.FIFTH, 0,
                Ranking.FOURTH, 0,
                Ranking.THRID, 1,
                Ranking.SECOND, 2,
                Ranking.FIRST, 1);

        Assertions.assertThat(rankingResults).isEqualTo(result);
    }
}