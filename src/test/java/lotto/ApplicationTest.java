package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
                List.of(2, 13, 32, 22, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 기능_사천원_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,33,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[3, 14, 16, 33, 42, 45]",
                            "[1, 2, 4, 5, 6, 33]",
                            "[1, 2, 4, 5, 7, 33]",
                            "[1, 2, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 50,750,125.0%입니다."
                    );
                },
                List.of(14, 3, 16, 33, 42, 45),
                List.of(4, 5, 6, 1, 2, 33),
                List.of(1, 2, 5, 7, 33, 4),
                List.of(1, 2, 5, 14, 22, 45)
        );
    }

    @Test
    void 기능_이천원_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,4,5,6,33", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 4, 7, 16, 32]",
                            "[1, 2, 4, 14, 22, 45]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(16, 1, 32, 4, 2, 7),
                List.of(1, 2, 22, 14, 45, 4)
        );
    }

    @Test
    void 기능_최대_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8145060000");
                    assertThat(output()).contains(
                            "구입금액을 입력해 주세요.",
                            "8145060000",
                            ERROR_MESSAGE);
                },
                List.of(16, 1, 32, 4, 2, 7),
                List.of(1, 2, 22, 14, 45, 4)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
