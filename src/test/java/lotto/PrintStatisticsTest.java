package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrintStatisticsTest extends NsTest {
    @Test
    void printResultTest() {
        run();
        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @Test
    void printYieldTest() {
        run();
        assertThat(output()).contains(
                "총 수익률은 62.5%입니다."
        );
    }

    @Override
    protected void runMain() {
        int myLottoCnt = 8;
        int[] totalWin = {0, 0, 0, 0, 1};
        int totalPrize = 5000;
        new PrintStatistics(myLottoCnt, totalWin, totalPrize);
    }
}