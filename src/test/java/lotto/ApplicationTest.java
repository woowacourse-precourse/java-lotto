package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("1등 당첨 테스트")
    void rank1Test() {
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
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    void rank2Test() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,41,42,43,44,45", "40");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[40, 41, 42, 43, 44, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 3000000.0%입니다."
                    );
                },
                List.of(40, 41, 42, 43, 44, 45)
        );
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    void rank3Test() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,41,42,43,44,45", "40");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[2, 41, 42, 43, 44, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 150000.0%입니다."
                    );
                },
                List.of(2, 41, 42, 43, 44, 45)
        );
    }

    @Test
    @DisplayName("4등 당첨 테스트")
    void rank4Test() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "30,31,32,33,34,35", "36");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[30, 31, 32, 33, 44, 45]",
                            "[1, 2, 3, 4, 44, 45]",
                            "[5, 6, 7, 8, 44, 45]",
                            "[10, 11, 12, 13, 44, 45]",
                            "[11, 21, 22, 23, 44, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1000.0%입니다."
                    );
                },
                List.of(30, 31, 32, 33, 44, 45),
                List.of(1, 2, 3, 4, 44, 45),
                List.of(5, 6, 7, 8, 44, 45),
                List.of(10, 11, 12, 13, 44, 45),
                List.of(11, 21, 22, 23, 44, 45)
        );
    }

    @Test
    @DisplayName("5등 당첨 테스트")
    void rank5Test() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "30,31,32,33,34,35", "36");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[30, 31, 32, 43, 44, 45]",
                            "[1, 2, 3, 4, 44, 45]",
                            "[5, 6, 7, 8, 44, 45]",
                            "[10, 11, 12, 13, 44, 45]",
                            "[11, 21, 22, 23, 44, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 100.0%입니다."
                    );
                },
                List.of(30, 31, 32, 43, 44, 45),
                List.of(1, 2, 3, 4, 44, 45),
                List.of(5, 6, 7, 8, 44, 45),
                List.of(10, 11, 12, 13, 44, 45),
                List.of(11, 21, 22, 23, 44, 45)
        );
    }

    @Test
    @DisplayName("수익률 소수점 둘째 자리 반올림 테스트")
    void profitTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("9000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "9개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "[1, 3, 7, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 55.6%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45),
                List.of(1, 3, 7, 14, 22, 45)
        );
    }

    @Test
    @DisplayName("정렬 테스트")
    void sortingTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[15, 16, 17, 18, 19, 20]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(20, 19, 18, 17, 16, 15)
        );
    }

    @Test
    void 예외_테스트() {
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
