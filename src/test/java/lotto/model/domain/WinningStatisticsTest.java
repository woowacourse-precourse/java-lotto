package lotto.model.domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("당첨통계 계산하기")
    @Test
    void WinningStatistics() {
        Lotto nothingLotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        Lotto fifthLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto fourthLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(nothingLotto, fifthLotto, fourthLotto, thirdLotto, secondLotto, firstLotto);
        String validWinningNumber = "1,2,3,4,5,6";
        String validBonusNumber = "7";
        WinningNumber winningNumber = new WinningNumber(validWinningNumber, validBonusNumber);
        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningNumber);
        Map<Rank, Integer> rankAndRankCount = winningStatistics.get();

        int nothingCount = rankAndRankCount.get(Rank.NOTHING);
        int fifthCount = rankAndRankCount.get(Rank.FIFTH);
        int fourthCount = rankAndRankCount.get(Rank.NOTHING);
        int thirdCount = rankAndRankCount.get(Rank.NOTHING);
        int secondCount = rankAndRankCount.get(Rank.NOTHING);
        int firstCount = rankAndRankCount.get(Rank.NOTHING);

        Assertions.assertThat(nothingCount)
                .isEqualTo(1);
        Assertions.assertThat(fifthCount)
                .isEqualTo(1);
        Assertions.assertThat(fourthCount)
                .isEqualTo(1);
        Assertions.assertThat(thirdCount)
                .isEqualTo(1);
        Assertions.assertThat(secondCount)
                .isEqualTo(1);
        Assertions.assertThat(firstCount)
                .isEqualTo(1);
    }

    @DisplayName("수익 계산하기")
    @Test
    void computeTotalYield() {
        Lotto fifthLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto fourthLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoReward200000000 = List.of(firstLotto);
        List<Lotto> lottoReward30000000 = List.of(secondLotto);
        List<Lotto> lottoReward1500000 = List.of(thirdLotto);
        List<Lotto> lottoReward50000 = List.of(fourthLotto);
        List<Lotto> lottoReward5000 = List.of(fifthLotto);
        String validWinningNumber = "1,2,3,4,5,6";
        String validBonusNumber = "7";
        WinningNumber winningNumber = new WinningNumber(validWinningNumber, validBonusNumber);
        WinningStatistics reward200000000 = new WinningStatistics(lottoReward200000000, winningNumber);
        WinningStatistics reward30000000 = new WinningStatistics(lottoReward30000000, winningNumber);
        WinningStatistics reward1500000 = new WinningStatistics(lottoReward1500000, winningNumber);
        WinningStatistics reward50000 = new WinningStatistics(lottoReward50000, winningNumber);
        WinningStatistics reward5000 = new WinningStatistics(lottoReward5000, winningNumber);

        double totalYield200000000 = reward200000000.computeTotalYield();
        double totalYield3000000 = reward30000000.computeTotalYield();
        double totalYield150000 = reward1500000.computeTotalYield();
        double totalYield5000 = reward50000.computeTotalYield();
        double totalYield500 = reward5000.computeTotalYield();

        Assertions.assertThat(totalYield200000000)
                .isEqualTo(2_000_000_00D, Offset.offset(0.1));
        Assertions.assertThat(totalYield3000000)
                .isEqualTo(30_000_00D, Offset.offset(0.1));
        Assertions.assertThat(totalYield150000)
                .isEqualTo(1_500_00D, Offset.offset(0.1));
        Assertions.assertThat(totalYield5000)
                .isEqualTo(50_00D, Offset.offset(0.1));
        Assertions.assertThat(totalYield500)
                .isEqualTo(5_00D, Offset.offset(0.1));
    }


}