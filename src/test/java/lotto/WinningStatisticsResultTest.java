package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsResultTest {

    private WinningStatisticsResult winningStatisticsResult;

    @Test
    void printWinningStatisticsTest1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    WinningStatistics winningStatistics = new WinningStatistics(8000);
                    winningStatistics.setWinningLottos(new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6))),7);
                    winningStatisticsResult = new WinningStatisticsResult(winningStatistics, 8000);
                    assertThat(winningStatisticsResult.printWinningStatistics())
                            .contains(
                                    "당첨 통계",
                                    "---",
                                    "3개 일치 (5,000원) - 1개",
                                    "4개 일치 (50,000원) - 0개",
                                    "5개 일치 (1,500,000원) - 0개",
                                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                                    "6개 일치 (2,000,000,000원) - 0개"
                            );
                },
                new ArrayList<>(List.of(8, 21, 23, 41, 42, 43)),
                new ArrayList<>(List.of(3, 5, 11, 16, 32, 38)),
                new ArrayList<>(List.of(7, 11, 16, 35, 36, 44)),
                new ArrayList<>(List.of(1, 8, 11, 31, 41, 42)),
                new ArrayList<>(List.of(13, 14, 16, 38, 42, 45)),
                new ArrayList<>(List.of(7, 11, 30, 40, 42, 43)),
                new ArrayList<>(List.of(13, 2, 22, 32, 38, 45)),
                new ArrayList<>(List.of(1, 3, 5, 14, 22, 45))
        );
    }

    @Test
    void printYieldTest1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    WinningStatistics winningStatistics = new WinningStatistics(8000);
                    winningStatistics.setWinningLottos(new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6))),7);
                    winningStatisticsResult = new WinningStatisticsResult(winningStatistics, 8000);
                    assertThat(winningStatisticsResult.printYield())
                            .contains(
                                    "총 수익률은 62.5%입니다."
                            );
                },
                new ArrayList<>(List.of(8, 21, 23, 41, 42, 43)),
                new ArrayList<>(List.of(3, 5, 11, 16, 32, 38)),
                new ArrayList<>(List.of(7, 11, 16, 35, 36, 44)),
                new ArrayList<>(List.of(1, 8, 11, 31, 41, 42)),
                new ArrayList<>(List.of(13, 14, 16, 38, 42, 45)),
                new ArrayList<>(List.of(7, 11, 30, 40, 42, 43)),
                new ArrayList<>(List.of(13, 2, 22, 32, 38, 45)),
                new ArrayList<>(List.of(1, 3, 5, 14, 22, 45))
        );
    }
}