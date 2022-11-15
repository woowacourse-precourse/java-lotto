package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
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
    @Test
    void bonus_test() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "5,16,25,26,34,35", "45");
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[1, 19, 21, 28, 35, 38]",
                            "[12, 13, 15, 27, 28, 33]",
                            "[6, 10, 19, 23, 27, 30]",
                            "[1, 18, 25, 32, 35, 45]",
                            "[20, 23, 27, 32, 39, 41]",
                            "[1, 7, 9, 24, 26, 42]",
                            "[5, 11, 19, 23, 38, 39]",
                            "[16, 19, 20, 28, 30, 35]",
                            "[15, 20, 21, 25, 27, 36]",
                            "[5, 16, 25, 26, 35, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 300000.0%입니다."
                    );
                },
                List.of(1, 19, 21, 28, 35, 38),
                List.of(12, 13, 15, 27, 28, 33),
                List.of(6, 10, 19, 23, 27, 30),
                List.of(1, 18, 25, 32, 35, 45),
                List.of(20, 23, 27, 32, 39, 41),
                List.of(1, 7, 9, 24, 26, 42),
                List.of(5, 11, 19, 23, 38, 39),
                List.of(16, 19, 20, 28, 30, 35),
                List.of(15, 20, 21, 25, 27, 36),
                List.of(5, 16, 25, 26, 35, 45)
        );
    }

    @Test
    void noninteger_test() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
