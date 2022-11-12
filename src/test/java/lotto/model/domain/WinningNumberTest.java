package lotto.model.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void 당첨통계_계산하기() {
        Lotto nothingLotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        Lotto fifthLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto fourthLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoCollection = List.of(nothingLotto, fifthLotto, fourthLotto, thirdLotto, secondLotto, firstLotto);
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");
        WinningStatistics winningStatistics = new WinningStatistics(lottoCollection, winningNumber);

        int nothingCount = winningStatistics.findRankCount(Rank.NOTHING);
        int fifthCount = winningStatistics.findRankCount(Rank.FIFTH);
        int fourthCount = winningStatistics.findRankCount(Rank.NOTHING);
        int thirdCount = winningStatistics.findRankCount(Rank.NOTHING);
        int secondCount = winningStatistics.findRankCount(Rank.NOTHING);
        int firstCount = winningStatistics.findRankCount(Rank.NOTHING);

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
}