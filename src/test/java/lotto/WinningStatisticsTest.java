package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {
    private WinningStatistics winningStatistics;

    @Test
    void printLottosTest1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    winningStatistics = new WinningStatistics(8000);
                    assertThat(winningStatistics.printLottos())
                            .contains(
                                    "8개를 구매했습니다.",
                                    "[8, 21, 23, 41, 42, 43]",
                                    "[3, 5, 11, 16, 32, 38]",
                                    "[7, 11, 16, 35, 36, 44]",
                                    "[1, 8, 11, 31, 41, 42]",
                                    "[13, 14, 16, 38, 42, 45]",
                                    "[7, 11, 30, 40, 42, 43]",
                                    "[2, 13, 22, 32, 38, 45]",
                                    "[1, 3, 5, 14, 22, 45]"
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
    void getCountWinningTest1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    winningStatistics = new WinningStatistics(8000);
                    winningStatistics.setWinningLottos(new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6))),7);
                    assertThat(winningStatistics.getCountWinning())
                        .isEqualTo(List.of(1, 0, 0, 0, 0));
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