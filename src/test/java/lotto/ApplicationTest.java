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

    @DisplayName("구입금액에 문자가 들어있으면 예외가 발생한다.")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입금액이 1000으로 나눠떨어지지 않으면 예외가 발생한다.")
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() -> {
            runException("999");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호는 1부터 45 사이의 숫자를 벗어나면 예외가 발생한다.")
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,48,","6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호는 문자가 있으면 예외가 발생한다.")
    @Test
    void 예외_테스트4() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,a", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호에 숫자가 아닌 문자가 있을 시, 예외 발생")
    @Test
    void 예외_테스트5() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "c");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 당첨 번호와 중첩될 시, 예외 발생")
    @Test
    void 예외_테스트6() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
