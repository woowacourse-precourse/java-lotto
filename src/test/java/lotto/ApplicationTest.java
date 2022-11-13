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

    @DisplayName("로또 게임이 올바르게 작동합니다.")
    @Test
    void functionTest() {
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

    @DisplayName("숫자가 아닌 구매 금액 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createAmountNotNum() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("1000으로 나누어떨어지지 않는 구매 금액 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createAmountNotDividedBy1000() {
        assertSimpleTest(() -> {
            runException("13500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자가 아닌 수로 이루어진 당첨 번호 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createWinningNumNotNum() {
        assertSimpleTest(() -> {
            runException("4000", "1, 2, 3, 4, 5, a", "10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("크가가 6보다 큰 당첨 번호 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createWinningNumBiggerThan6() {
        assertSimpleTest(() -> {
            runException("4000", "1, 2, 3, 4, 5, 6, 7", "10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("크기가 6보다 작은 당첨 번호 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createWinningNumSmallerThan6() {
        assertSimpleTest(() -> {
            runException("4000", "1, 2, 3, 4, 5", "10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("중복되는 당첨 번호 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createWinningNumNotUnique() {
        assertSimpleTest(() -> {
            runException("4000", "1, 2, 3, 4, 5, 5", "10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("범위 밖의 당첨 번호 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createWinningNumNotInRange() {
        assertSimpleTest(() -> {
            runException("4000", "1, 2, 3, 4, 5, 48", "10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자가 아닌 보너스 번호 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createBonusNumNotNum() {
        assertSimpleTest(() -> {
            runException("4000", "1, 2, 3, 4, 5, 6", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("범위 밖의 보너스 번호 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createBonusNumNotInRange() {
        assertSimpleTest(() -> {
            runException("4000", "1, 2, 3, 4, 5, 6", "48");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호 입력에 대해서 올바른 에러 메시지를 출력합니다.")
    @Test
    void createBonusNumNotUnique() {
        assertSimpleTest(() -> {
            runException("4000", "1, 2, 3, 4, 5, 6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
