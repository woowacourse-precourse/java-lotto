package lotto.model.domain;


import java.util.List;
import java.util.Map;
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
}