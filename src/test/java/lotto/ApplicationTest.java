package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("전체 프로그램 동작 과정을 테스트한다.")
    @Nested
    class FunctionTest {
        @Test
        void 기능_테스트_미션_초기값() {
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
        void 기능_테스트_여러개_당첨() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("5000", "1,2,6,7,30,45", "32");
                        assertThat(output()).contains(
                                "5개를 구매했습니다.",
                                "[1, 2, 6, 7, 42, 45]",
                                "[1, 2, 6, 7, 32, 45]",
                                "[1, 3, 6, 7, 36, 45]",
                                "[1, 3, 6, 7, 41, 45]",
                                "[1, 4, 6, 7, 40, 42]",
                                "3개 일치 (5,000원) - 1개",
                                "4개 일치 (50,000원) - 2개",
                                "5개 일치 (1,500,000원) - 1개",
                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                                "6개 일치 (2,000,000,000원) - 0개",
                                "총 수익률은 632100.0%입니다."
                        );
                    },
                    List.of(1, 2, 6, 7, 42, 45),
                    List.of(1, 2, 6, 7, 32, 45),
                    List.of(1, 3, 6, 7, 36, 45),
                    List.of(1, 3, 6, 7, 41, 45),
                    List.of(1, 4, 6, 7, 40, 42)
            );
        }

        @Test
        void 기능_테스트_1등_당첨() {
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
        void 기능_테스트_2등_당첨() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("1000", "1,2,3,4,5,6", "7");
                        assertThat(output()).contains(
                                "1개를 구매했습니다.",
                                "[1, 2, 3, 4, 5, 7]",
                                "3개 일치 (5,000원) - 0개",
                                "4개 일치 (50,000원) - 0개",
                                "5개 일치 (1,500,000원) - 0개",
                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                                "6개 일치 (2,000,000,000원) - 0개",
                                "총 수익률은 3000000.0%입니다."
                        );
                    },
                    List.of(1, 2, 3, 4, 5, 7)
            );
        }

        @Test
        void 기능_테스트_3등_당첨() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("1000", "1,2,3,4,5,6", "7");
                        assertThat(output()).contains(
                                "1개를 구매했습니다.",
                                "[1, 2, 3, 4, 5, 8]",
                                "3개 일치 (5,000원) - 0개",
                                "4개 일치 (50,000원) - 0개",
                                "5개 일치 (1,500,000원) - 1개",
                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                                "6개 일치 (2,000,000,000원) - 0개",
                                "총 수익률은 150000.0%입니다."
                        );
                    },
                    List.of(1, 2, 3, 4, 5, 8)
            );
        }

        @Test
        void 기능_테스트_모두_당첨_실패() {
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
                    List.of(15, 16, 17, 18, 19, 20)
            );
        }
    }

    @DisplayName("구입 금액 예외 발생을 테스트한다.")
    @Nested
    class PurchaseAmountExceptionTest {
        @Test
        void 예외_테스트_숫자_아닌_입력() {
            assertSimpleTest(() -> {
                runException("1000j");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_빈값_입력() {
            assertSimpleTest(() -> {
                runException(" ");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_10의_배수_아닌_입력() {
            assertSimpleTest(() -> {
                runException("1500");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @DisplayName("당첨 번호 예외 발생을 테스트한다.")
    @Nested
    class WinningNumbersExceptionTest {
        @Test
        void 예외_테스트_컴마_아닌_구분_입력() {
            assertSimpleTest(() -> {
                runException("10000", "1-2-3-4-5-6");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
        @Test
        void 예외_테스트_숫자_아닌_당첨_번호_입력() {
            assertSimpleTest(() -> {
                runException("10000", "1,2,3,4,5,a");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_숫자_6개_아닌_입력() {
            assertSimpleTest(() -> {
                runException("10000", "1,2,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_숫자_범위_벗어난_입력() {
            assertSimpleTest(() -> {
                runException("10000", "1,2,3,4,5,50");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @DisplayName("보너스 번호 예외 발생을 테스트한다.")
    @Nested
    class BonusNumberExceptionTest {
        @Test
        void 예외_테스트_빈칸_입력() {
            assertSimpleTest(() -> {
                runException("10000", "1,2,3,4,5,6", " ");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
        @Test
        void 예외_테스트_숫자_아닌_문자_입력() {
            assertSimpleTest(() -> {
                runException("10000", "1,2,3,4,5,6", "a");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_당첨_번호_중복_숫자_입력() {
            assertSimpleTest(() -> {
                runException("10000", "1,2,3,4,5,6", "6");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_숫자_범위_벗어난_입력() {
            assertSimpleTest(() -> {
                runException("10000", "1,2,3,4,5,6", "50");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
