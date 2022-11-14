package lotto.model.domain;

import java.util.List;
import java.util.Map;
import lotto.model.dto.WinningNumberDto;
import lotto.model.dto.WinningStatisticsDto;
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
        WinningNumberDto winningNumberDto = winningNumber.toDto();
        Lotto winningLotto = winningNumberDto.getLotto();
        BonusNumber bonusNumber = winningNumberDto.getBonusNumber();
        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningLotto, bonusNumber);
        WinningStatisticsDto winningStatisticsDto = winningStatistics.toDto();
        Map<Rank, Integer> rankAndRankCount = winningStatisticsDto.getRankAndRankCount();

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
        List<Lotto> lottoReward5000 = List.of(fifthLotto);
        String validWinningNumber = "1,2,3,4,5,6";
        String validBonusNumber = "7";
        WinningNumber winningNumber = new WinningNumber(validWinningNumber, validBonusNumber);
        WinningNumberDto winningNumberDto = winningNumber.toDto();
        Lotto winningLotto = winningNumberDto.getLotto();
        BonusNumber bonusNumber = winningNumberDto.getBonusNumber();
        WinningStatistics winningStatistics = new WinningStatistics(lottoReward5000, winningLotto, bonusNumber);
        WinningStatisticsDto winningStatisticsDto = winningStatistics.toDto();

        double totalYield500 = winningStatisticsDto.getTotalYield();

        Assertions.assertThat(totalYield500)
                .isEqualTo(5_00D, Offset.offset(0.1));
    }
}