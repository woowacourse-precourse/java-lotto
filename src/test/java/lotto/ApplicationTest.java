package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import user.User;
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
    //구매 금액 검증
    @DisplayName("구매 금액은 숫자로만 이루어져야 한다.")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("구매 금액은 null일 수 없다.")
    @Test
    void checkInputNull() {
        assertSimpleTest(() -> {
            String test = null;
            runException(test);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("구매 금액은 비어있는 문자열 일 수 없다..")
    @Test
    void checkInputBlank() {
        assertSimpleTest(() -> {
            runException("");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("구매 금액은 0으로 시작하지 않는다.")
    @Test
    void checkInputStartWithZero() {
        assertSimpleTest(() -> {
            runException("01000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("구매 금액은 1000으로 나누어 떨어져야 한다.")
    @Test
    void checkInputDivide1000() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("구매 금액은 1000보다 작을 수 없다.")
    @Test
    void checkInput() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    // 당첨 로또 검증
    @DisplayName("수익률 검증 소수점 반올림 확인")
    @Test
    void checkRatio() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("6000", "1,2,3,37,38,39", "45");
                    assertThat(output()).contains(
                            "6개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[7, 8, 9, 10, 11, 12]",
                            "[13, 14, 15, 16, 17, 18]",
                            "[19, 20, 21, 22, 23, 24]",
                            "[25, 26, 27, 28, 29, 30]",
                            "[31, 32, 33, 34, 35, 36]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 83.3%입니다."
                    );
                },
                List.of(1,2,3,4,5,6),
                List.of(7,8,9,10,11,12),
                List.of(13,14,15,16,17,18),
                List.of(19 , 20, 21, 22, 23, 24),
                List.of(25, 26, 27, 28, 29, 30),
                List.of(31, 32, 33, 34, 35, 36)
        );
    }
    @DisplayName("수익률 검증 구입과 수입이 동일 할 때")
    @Test
    void checkRatio100() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,37,38,39", "45");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[7, 8, 9, 10, 11, 12]",
                            "[13, 14, 15, 16, 17, 18]",
                            "[19, 20, 21, 22, 23, 24]",
                            "[25, 26, 27, 28, 29, 30]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 100.0%입니다."
                    );
                },
                List.of(1,2,3,4,5,6),
                List.of(7,8,9,10,11,12),
                List.of(13,14,15,16,17,18),
                List.of(19 , 20, 21, 22, 23, 24),
                List.of(25, 26, 27, 28, 29, 30)
        );
    }
    // 보너스 번호 검증
    @Test
    @DisplayName("보너스 숫자 null 확인")
    void bonusNumberNull() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", null);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 숫자 빈 문자열 확인")
    void bonusNumberEmpty() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 숫자 중복 확인")
    void bonusNumberDuplicate() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 숫자 로또 숫자인지 확인")
    void bonusNumberOutRange() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
