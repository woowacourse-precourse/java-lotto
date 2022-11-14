package lotto.score;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.publisher.Lotto;
import lotto.publisher.WinnerLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreCheckerTest {

    @DisplayName("로또 당첨 결과를 가져온다. (1등 1개)")
    @Test
    void lottoStorageTest() {
        List<Lotto> myLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );

        WinnerLotto.getInstance().setWinnerLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinnerLotto.getInstance().setBonusNumber(45);

        Score score = new ScoreChecker().getMyScore(myLottos, WinnerLotto.getInstance());
        int lottoPrice = 1000 * myLottos.size();

        double expectedRewardPercentage =
                Math.round(Grade.FIRST.getReward() / (double) lottoPrice * 100 * 10) / 10.0;

        double actualResult = Math.round(score.getRewardPercentage() * 10) / 10.0;

        assertThat(actualResult).isEqualTo(expectedRewardPercentage);
    }

    @DisplayName("로또 당첨 결과를 가져온다. (5등 1개)")
    @Test
    void lottoNaturalOrderTest() {
        List<Lotto> myLottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        WinnerLotto.getInstance().setWinnerLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinnerLotto.getInstance().setBonusNumber(7);

        Score score = new ScoreChecker().getMyScore(myLottos, WinnerLotto.getInstance());
        int lottoPrice = 1000 * myLottos.size();

        double expectedRewardPercentage =
                Math.round(Grade.FIFTH.getReward() / (double) lottoPrice * 100 * 10) / 10.0;

        double actualResult = Math.round(score.getRewardPercentage() * 10) / 10.0;

        assertThat(actualResult).isEqualTo(expectedRewardPercentage);
    }
}