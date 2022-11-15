package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    List<Lotto> lottos;
    WinningLotto winningLotto;

    @BeforeEach
    void init() {
        lottos = new LinkedList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 45)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 44, 45)));
        lottos.add(new Lotto(List.of(1, 2, 3, 43, 44, 45)));
        lottos.add(new Lotto(List.of(1, 2, 42, 43, 44, 45)));

        winningLotto = new WinningLotto(List.of("1","2","3","4","5","6"));
        winningLotto.pickBonusBall("7");
    }

    @DisplayName("당첨된 로또들의 통계 생성 테스트")
    @Test
    void createLottoStatistics() {
        Statistics lottoStatistics = new Statistics(lottos, winningLotto);
        assertThat(lottoStatistics.getLottosResult().get(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoStatistics.getLottosResult().get(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoStatistics.getLottosResult().get(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoStatistics.getLottosResult().get(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoStatistics.getLottosResult().get(Rank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("당첨된 로또들의 수익률 테스트")
    @Test
    void getYieldTest() {
        Statistics lottoStatistics = new Statistics(lottos, winningLotto);
        assertThat(String.format("%.1f", lottoStatistics.getYield(6000))).isEqualTo("33859250.0");
    }
}