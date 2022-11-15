package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    private static final WinningLotto winningLotto =
            new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

    @DisplayName("6개 숫자가 일치할 경우 1등이다.")
    @Test
    void firstPlaceTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Result result = new Result(winningLotto, new User(1000));
                    assertThat(result.getRankResult(Rank.FIRST)).isEqualTo(1);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("5개 숫자와 보너스 번호가 일치할 경우 2등이다.")
    @Test
    void secondPlaceTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Result result = new Result(winningLotto, new User(1000));
                    assertThat(result.getRankResult(Rank.SECOND)).isEqualTo(1);
                },
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @DisplayName("5개 숫자가 일치할 경우 3등이다.")
    @Test
    void thirdPlaceTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Result result = new Result(winningLotto, new User(1000));
                    assertThat(result.getRankResult(Rank.THIRD)).isEqualTo(1);
                },
                List.of(1, 2, 3, 4, 5, 8)
        );
    }

    @DisplayName("4개 숫자가 일치할 경우 4등이다.")
    @Test
    void fourthPlaceTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Result result = new Result(winningLotto, new User(1000));
                    assertThat(result.getRankResult(Rank.FOURTH)).isEqualTo(1);
                },
                List.of(1, 2, 3, 4, 7, 8)
        );
    }

    @DisplayName("3개 숫자가 일치할 경우 5등이다.")
    @Test
    void fifthPlaceTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Result result = new Result(winningLotto, new User(1000));
                    assertThat(result.getRankResult(Rank.FIFTH)).isEqualTo(1);
                },
                List.of(1, 2, 3, 7, 8, 9)
        );
    }

    @DisplayName("수익률을 정확히 계산한다.")
    @Test
    void rateOfReturnTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Result result = new Result(winningLotto, new User(8000));
                    assertThat(result.getRateOfReturn()).isEqualTo(62.5f);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
}
