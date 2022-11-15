package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculationTest {
    private final Lotto winningLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    private final Bonus bonus = new Bonus(10);
    private final LottoCalculation lottoCalculation = new LottoCalculation(winningLotto, bonus);

    @DisplayName("당첨 로또와 발행된 각 로또의 일치하는 개수를 계산한다.")
    @Test
    void 일치하는_숫자_갯수_계산_테스트() {
        int sameNumberCount = 3;
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        assertThat(lottoCalculation.countSameNumber(userLotto.getNumbers())).isEqualTo(sameNumberCount);
    }

    @DisplayName("발행된 로또의 당첨 결과를 구한다.")
    @Test
    void 당첨_결과_계산_테스트_1() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        lottoCalculation.computeWinningResult(userLotto);
        Map<WinningScore, Integer> result = lottoCalculation.getStatisticsResult().getWinningScoreResult();
        List<Integer> scoreCount = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0));
        int i = 0;
        for (WinningScore score : WinningScore.values()) {
            if (score == WinningScore.NONE) {
                continue;
            }
            assertThat(result.get(score)).isEqualTo(scoreCount.get(i));
            i += 1;
        }
    }

    @DisplayName("발행된 로또의 당첨 결과를 구한다.")
    @Test
    void 당첨_결과_계산_테스트_2() {
        lottoCalculation.computeWinningResult(new Lotto(List.of(1, 2, 3, 4, 5, 10)));
        lottoCalculation.computeWinningResult(new Lotto(List.of(1, 2, 3, 4, 11, 13)));

        Map<WinningScore, Integer> result = lottoCalculation.getStatisticsResult().getWinningScoreResult();
        List<Integer> scoreCount = new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0));
        int i = 0;
        for (WinningScore score : WinningScore.values()) {
            if (score == WinningScore.NONE) {
                continue;
            }
            assertThat(result.get(score)).isEqualTo(scoreCount.get(i));
            i += 1;
        }
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률_계산_테스트() {
        int purchaseAmount = 8000;
        lottoCalculation.computeWinningResult(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        assertThat(lottoCalculation.computeRateOfReturn(purchaseAmount)).isEqualTo(62.5);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률_계산_테스트_2() {
        int purchaseAmount = 5000;
        lottoCalculation.computeWinningResult(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        assertThat(lottoCalculation.computeRateOfReturn(purchaseAmount)).isEqualTo(100.0);
    }
}