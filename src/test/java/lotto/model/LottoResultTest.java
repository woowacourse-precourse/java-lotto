package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.util.constants.WinningScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private Lotto winningLotto;
    private final static int bonusNumber = 10;

    private WinningLotto winning;
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        winning = new WinningLotto(winningLotto, bonusNumber);
        lottoResult = new LottoResult(bonusNumber);
    }

    @DisplayName("당첨 로또와 발행된 각 로또의 일치하는 개수를 계산한다.")
    @Test
    void 일치하는_숫자_갯수_계산_테스트() {
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        WinningScore winningScore = lottoResult.compareNumber(userLotto.getNumbers(),
                winningLotto.getNumbers());
        assertThat(winningScore.name()).isEqualTo(WinningScore.THREE.name());
    }

    @DisplayName("발행된 로또의 당첨 결과를 구한다.")
    @Test
    void 당첨_결과_계산_테스트_1() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        lottoResult.computeWinningScore(userLotto, winningLotto);
        Map<WinningScore, Integer> result = lottoResult.getWinningScoreResult();
        List<Integer> scoreCount = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0));
        int i = 0;
        for (WinningScore score : WinningScore.values()) {
            assertThat(result.get(score)).isEqualTo(scoreCount.get(i));
            i += 1;
        }
    }

    @DisplayName("발행된 로또의 당첨 결과를 구한다.")
    @Test
    void 당첨_결과_계산_테스트_2() {
        lottoResult.computeWinningScore(new Lotto(List.of(1, 2, 3, 4, 5, 10)), winningLotto);
        lottoResult.computeWinningScore(new Lotto(List.of(1, 2, 3, 4, 11, 13)), winningLotto);

        Map<WinningScore, Integer> result = lottoResult.getWinningScoreResult();
        List<Integer> scoreCount = new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0));
        int i = 0;
        for (WinningScore score : WinningScore.values()) {
            assertThat(result.get(score)).isEqualTo(scoreCount.get(i));
            i += 1;
        }
    }
}