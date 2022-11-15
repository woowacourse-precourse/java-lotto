package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningCalculatorTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("당첨번호와 구매 티켓 3개 일치를 확인합니다.")
    @Test
    void 당첨번호와_구매티켓_3개_일치_테스트() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개"
                );
            },
            List.of(1, 3, 5, 14, 22, 45),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @DisplayName("당첨번호와 구매 티켓 4개 일치를 확인합니다.")
    @Test
    void 당첨번호와_구매티켓_4개_일치_테스트() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개"
                );
            },
            List.of(1, 2, 3, 4, 42, 43),
            List.of(13, 14, 25, 26, 32, 38),
            List.of(11, 23, 24, 26, 36, 44)
        );
    }


    @DisplayName("당첨번호와 구매 티켓 5개 일치를 확인합니다.")
    @Test
    void 당첨번호와_구매티켓_5개_일치_테스트() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개"
                );
            },
            List.of(1, 2, 3, 4, 5, 43),
            List.of(13, 14, 25, 26, 32, 38),
            List.of(11, 23, 24, 26, 36, 44)
        );
    }

    @DisplayName("당첨번호와 구매 티켓 5개, 보너스번호 일치를 확인합니다.")
    @Test
    void 당첨번호와_구매티켓_5개와_보너스_일치_테스트() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 0개"
                );
            },
            List.of(1, 2, 3, 4, 5, 7),
            List.of(13, 14, 25, 26, 32, 38),
            List.of(11, 23, 24, 26, 36, 44)
        );
    }

    @DisplayName("당첨번호와 구매 티켓 6개 일치를 확인합니다.")
    @Test
    void 당첨번호와_구매티켓_6개_일치_테스트() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 1개"
                );
            },
            List.of(1, 2, 3, 4, 5, 6),
            List.of(13, 14, 25, 26, 32, 38),
            List.of(11, 23, 24, 26, 36, 44)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}