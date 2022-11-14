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
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("1등 당첨인 경우 6개 일치에 1개로 출력된다.")
    @Test
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "8,21,23,41,42,43", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200000000.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("2등 당첨인 경우 5개 일치, 보너스 볼 일치에 1개로 출력된다.")
    @Test
    void 기능_테스트3() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "8,21,23,41,42,45", "43");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 3000000.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("3등 당첨인 경우 5개 일치에 1개로 출력된다.")
    @Test
    void 기능_테스트4() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "8,21,23,41,42,45", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 150000.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("4등 당첨인 경우 4개 일치에 1개로 출력된다.")
    @Test
    void 기능_테스트5() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "8,21,23,41,44,45", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 5000.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("5등 당첨인 경우 3개 일치에 1개로 출력된다.")
    @Test
    void 기능_테스트6() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "8,21,23,40,44,45", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("정렬 안된 로또번호를 정렬해서 출력한다.")
    @Test
    void 기능_테스트7() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "8,21,23,40,44,45", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(21, 8, 41, 23, 42, 43)
        );
    }

    @DisplayName("구매금액에 숫자가 아닌 다른것이 입력되면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매금액을 1000단위로 입력하지 않으면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() -> {
            runException("1200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 숫자를 6개 이상 입력하면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 숫자를 1~45 범위 밖으로 입력하면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트4() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 숫자를 1~45 범위 밖으로 입력하면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트5() {
        assertSimpleTest(() -> {
            runException("1000", "0,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 숫자에 숫자 이외의 다른것이 입력되면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트6() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6s");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 숫자를 6개보다 적게 입력하면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트7() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 숫자의 구분을 ',' 가 아닌 다른것으로 하면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트8() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5.6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 숫자와 당첨 숫자가 중복되면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트9() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 숫자를 1~45 범위 밖으로 입력하면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트10() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 숫자를 1~45 범위 밖으로 입력하면예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트11() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 숫자에 숫자 이외의 것을 입력하면 예외가 발생하며 프로그램이 종료된다.")
    @Test
    void 예외_테스트12() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "s");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 숫자에 구분자(',')를 5개 초과로 넣으면 에러가 발생한다")
    @Test
    void 예외_테스트13() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
