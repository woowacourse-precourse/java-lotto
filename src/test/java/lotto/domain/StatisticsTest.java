package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    private final Statistics statistics = new Statistics();

    @BeforeEach
    void init() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Lotto> lottos = List.of(lotto1, lotto2);
        statistics.makeStatistics(winningLotto, lottos);
    }

    @Test
    void rankings초기화_테스트() {
        System.out.println(statistics.getYield());
        assertThat(statistics.getRankings()).hasSize(5);
    }

    @Test
    void rankings순위_테스트() {
        Map<Integer, Integer> rankings = statistics.getRankings();

        assertThat(rankings.get(1)).isEqualTo(0);
        assertThat(rankings.get(2)).isEqualTo(1);
        assertThat(rankings.get(3)).isEqualTo(0);
        assertThat(rankings.get(4)).isEqualTo(0);
        assertThat(rankings.get(5)).isEqualTo(1);
    }

    @Test
    void 수익률_계산_테스트() {
        assertThat(statistics.getYield()).isEqualTo(1500250.0);
    }
}