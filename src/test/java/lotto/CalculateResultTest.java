package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculateResultTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_3개일치_성공_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 10, 11, 12]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 10, 11, 12),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 로또_3개일치1개_4개일치1개_성공_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 6, 10, 11]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 10, 11, 6),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 로또_5개일치_보너스불일치_성공_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "2,3,4,5,6,7", "8");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[2, 3, 4, 5, 6, 10]",
                            "[2, 3, 4, 6, 7, 20]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 3개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 10),
                List.of(2, 3, 4, 6, 7, 20)
        );
    }

    @Test
    void 로또_5개일치_보너스일치_성공_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "2,3,4,5,6,7", "8");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[2, 3, 4, 5, 6, 8]",
                            "[2, 3, 4, 6, 7, 8]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 8),
                List.of(2, 3, 4, 6, 7, 8)
        );
    }

    @Test
    void 로또_6개일치_성공_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
