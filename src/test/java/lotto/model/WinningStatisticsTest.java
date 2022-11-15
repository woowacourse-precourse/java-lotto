package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @DisplayName("일치 개수에 따라 몇개 당첨인지 계산한다.(no_match 7개, 3개 일치 1개)")
    @Test
    void getWinningDetailsest() {
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));

        LottoGroup lottoGroup = new LottoGroup(
                List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8));
        AnswerLotto answerLotto = new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(lottoGroup,
                answerLotto);

        assertThat(winningDetails.get(WinningRank.NO_MATCH)).isEqualTo(7);
        assertThat(winningDetails.get(WinningRank.THREE_MATCH)).isEqualTo(1);
        assertThat(winningDetails.get(WinningRank.FOUR_MATCH)).isEqualTo(0);
        assertThat(winningDetails.get(WinningRank.FIVE_MATCH)).isEqualTo(0);
        assertThat(winningDetails.get(WinningRank.FIVE_MATCH_BONUS)).isEqualTo(0);
        assertThat(winningDetails.get(WinningRank.SIX_MATCH)).isEqualTo(0);

    }

    @DisplayName("당첨 금액을 구한다.")
    @Test
    void getWinningAmountTest() {
        Map<WinningRank, Integer> winningDetails = WinningStatistics.createWinningDetails();
        winningDetails.replace(WinningRank.NO_MATCH, 3);
        winningDetails.replace(WinningRank.THREE_MATCH, 1);
        winningDetails.replace(WinningRank.FOUR_MATCH, 1);
        winningDetails.replace(WinningRank.FIVE_MATCH, 1);
        winningDetails.replace(WinningRank.FIVE_MATCH_BONUS, 1);
        winningDetails.replace(WinningRank.SIX_MATCH, 1);

        long winningAmount = WinningStatistics.getWinningAmount(winningDetails);
        assertThat(winningAmount).isEqualTo(2031555000);
    }

    @DisplayName("총 수익률을 구한다.")
    @Test
    void getLottoYieldTest() {
        double lottoYield;
        lottoYield = WinningStatistics.getLottoYield(5000, 8000);
        assertThat(lottoYield).isEqualTo(62.5);
    }
}
