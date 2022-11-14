package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsMakerTest {

    private final StatisticsMaker statisticsMaker = new StatisticsMaker();
    private final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    private final List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 41, 42, 43)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)));

    @DisplayName("성공적으로 랭킹이 초기화 되었다면 랭킹은 5개의 길이를 가진다.")
    @Test
    void initializeRanking() {
        Map<Integer, Integer> ranking = statisticsMaker.makeRankings(winningLotto, lottos);

        assertThat(ranking).hasSize(5);
    }

    @DisplayName("키를 순위, 밸류를 당첨횟수를 가지는 맵이 업데이트 된다.")
    @Test
    void updateRankingByWinningLotto() {
        Map<Integer, Integer> ranking = statisticsMaker.makeRankings(winningLotto, lottos);

        assertThat(ranking.get(1)).isEqualTo(0);
        assertThat(ranking.get(2)).isEqualTo(1);
        assertThat(ranking.get(3)).isEqualTo(0);
        assertThat(ranking.get(4)).isEqualTo(0);
        assertThat(ranking.get(5)).isEqualTo(1);
    }


    @DisplayName("Ranking")
    @Test
    void createYieldByUpdatedRanking() {
        Map<Integer, Integer> ranking = statisticsMaker.makeRankings(winningLotto, lottos);
        double yield = statisticsMaker.makeYield(lottos, ranking);

        assertThat(yield).isEqualTo(1500250.0);
    }
}