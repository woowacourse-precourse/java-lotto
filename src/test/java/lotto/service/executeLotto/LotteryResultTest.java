package lotto.service.executeLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LotteryResultTest {
    @DisplayName("3등 1개")
    @Test
    void getScoreTest1() {
        List<List<Integer>> USER_LOTTERIES = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45));

        List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
        int BONUS = 7;
        Map<Integer, Integer> EXPECTED_RESULT = Map.of(0, 0, 3, 1, 4, 0, 5, 0, 6, 0);

        LotteryResult compare = new LotteryResult(USER_LOTTERIES, WINNING_NUMBERS);
        Map<Integer, Integer> result = compare.getScores(BONUS);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("3등 1개 총 수익률 계산")
    @Test
    void getTotalPrizeTest1() {
        List<List<Integer>> USER_LOTTERIES = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45));

        List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
        int BONUS = 7;

        double EXPECTED_RESULT = 62.5;
        LotteryResult compare = new LotteryResult(USER_LOTTERIES, WINNING_NUMBERS);
        Map<Integer, Integer> result = compare.getScores(BONUS);

        assertThat(compare.getYield(result)).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("보너스 1개, 3등 1개")
    @Test
    void getScoreTest2() {
        List<List<Integer>> USER_LOTTERIES = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 3, 5, 14, 22, 45));

        List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
        int BONUS = 7;
        Map<Integer, Integer> EXPECTED_RESULT = Map.of(0, 1, 3, 1, 4, 0, 5, 0, 6, 0);

        LotteryResult compare = new LotteryResult(USER_LOTTERIES, WINNING_NUMBERS);
        Map<Integer, Integer> result = compare.getScores(BONUS);

        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }
}
