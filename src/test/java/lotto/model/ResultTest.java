package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    private static final WinningLotto winningLotto =
            new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

    @DisplayName("6개 숫자가 일치할 경우 1등이다.")
    @Test
    void firstPlaceTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Result result = new Result(winningLotto, List.of(lotto), 1000);

        assertThat(result.getRankResult(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("5개 숫자와 보너스 번호가 일치할 경우 2등이다.")
    @Test
    void secondPlaceTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Result result = new Result(winningLotto, List.of(lotto), 1000);

        assertThat(result.getRankResult(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("5개 숫자가 일치할 경우 3등이다.")
    @Test
    void thirdPlaceTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Result result = new Result(winningLotto, List.of(lotto), 1000);

        assertThat(result.getRankResult(Rank.THIRD)).isEqualTo(1);
    }

    @DisplayName("4개 숫자가 일치할 경우 4등이다.")
    @Test
    void fourthPlaceTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Result result = new Result(winningLotto, List.of(lotto), 1000);

        assertThat(result.getRankResult(Rank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("3개 숫자가 일치할 경우 5등이다.")
    @Test
    void fifthPlaceTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Result result = new Result(winningLotto, List.of(lotto), 1000);

        assertThat(result.getRankResult(Rank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("수익률을 정확히 계산한다.")
    @Test
    void rateOfReturnTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        Result result = new Result(winningLotto, lottos, 8000);
        assertThat(result.getRateOfReturn()).isEqualTo(62.5f);
    }
}
