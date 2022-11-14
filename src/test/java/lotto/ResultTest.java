package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    Result result;

    @BeforeEach
    void setUp() {
        List<List<Integer>> myLotto = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int winningBonus = 7;
        result = new Result(myLotto, winningLotto, winningBonus);
    }

    @Test
    void judgeWinTest() {
        int[] expectedTotalWin = {0, 0, 0, 0, 1};
        for (int i = 0; i < expectedTotalWin.length; i++) {
            assertThat(result.totalWin[i]).isEqualTo(expectedTotalWin[i]);
        }
    }

    @Test
    void calculateTotalPrizeTest() {
        assertThat(result.totalPrize).isEqualTo(5000);
    }
}