package lotto.model.domain;


import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
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

    @Test
    void 수익률_계산하기() {
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
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");
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
                .isEqualTo(200_000_000D, Offset.offset(1.0));
        Assertions.assertThat(totalYield3000000)
                .isEqualTo(3_000_000D, Offset.offset(1.0));
        Assertions.assertThat(totalYield150000)
                .isEqualTo(150_000D, Offset.offset(1.0));
        Assertions.assertThat(totalYield5000)
                .isEqualTo(5_000D, Offset.offset(1.0));
        Assertions.assertThat(totalYield500)
                .isEqualTo(500D, Offset.offset(1.0));
    }

    @Test
    void 당첨_번호_정상적인_입력값_처리하기() {
        Assertions.assertThatCode(() -> new WinningNumber(" 1 , 2 , 3 , 4 , 5 , 6 ", "7"))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨_번호_비정상적인_입력값_처리하기() {
        Assertions.assertThatThrownBy(() -> new WinningNumber("1,2,,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber(",1,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber("0,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber("46,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber("6,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_정상적인_입력값_처리하기() {
        Assertions.assertThatCode(() -> new WinningNumber("1,2,3,4,5,6", " 7 "))
                .doesNotThrowAnyException();
    }

    @Test
    void 보너스_번호_비정상적인_입력값_처리하기() {
        Assertions.assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "10a"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "a"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "46"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}