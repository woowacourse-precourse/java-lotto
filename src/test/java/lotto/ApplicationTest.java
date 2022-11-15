package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("1. 예외1 : 숫자를 입력하지 않은 경우")
    void test1() {
        assertSimpleTest(() -> {
            runException("문자");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("1. 예외2 : 숫자이지만 1000원 단위가 아닌 경우")
    void test2() {
        assertSimpleTest(() -> {
            runException("1005");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("3. 예외1 : 올바른 형식이 아닌 경우")
    void test3() {
        Service service = new Service();
        assertSimpleTest(() -> assertThatThrownBy(() -> service.checkWinningNumber0("123456")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("3. 예외2 : 6개 숫자가 아닌 경우")
    void test4() {
        Service service = new Service();
        assertSimpleTest(() -> assertThatThrownBy(() -> service.checkWinningNumber0("1,2,3,4,5")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("3. 예외3 : 중복된 숫자가 있는 경우")
    void test5() {
        Service service = new Service();
        assertSimpleTest(() -> assertThatThrownBy(() -> service.checkWinningNumber0("1,2,3,4,5,5")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("3. 예외4 : 숫자를 입력하지 않은 경우")
    void test6() {
        Service service = new Service();
        String[] input = {"1", "2", "3", "4", "5", "문자"};
        assertSimpleTest(() -> assertThatThrownBy(() -> service.checkWinningNumber1(input)).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("3. 예외5 : 1 ~ 45 범위를 벗어나는 경우")
    void test7() {
        Service service = new Service();
        String[] input = {"1", "2", "3", "4", "5", "46"};
        assertSimpleTest(() -> assertThatThrownBy(() -> service.checkWinningNumber1(input)).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("4. 예외 1: 당첨 번호와 중복되는 경우")
    void test8() {
        Service service = new Service();
        String winningNumber = "1,2,3,4,5,6";
        String luckyNumber = "6";
        assertSimpleTest(() -> assertThatThrownBy(() -> service.checkLuckyNumber0(luckyNumber, winningNumber)).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("4. 예외 2: 숫자를 입력하지 않은 경우")
    void test9() {
        Service service = new Service();
        String winningNumber = "1,2,3,4,5,6";
        String luckyNumber = "문자";
        assertSimpleTest(() -> assertThatThrownBy(() -> service.checkLuckyNumber0(luckyNumber, winningNumber)).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("4. 예외 3: 1 ~ 45 범위를 벗어나는 경우")
    void test10() {
        Service service = new Service();
        String winningNumber = "1,2,3,4,5,6";
        String luckyNumber = "46";
        assertSimpleTest(() -> assertThatThrownBy(() -> service.checkLuckyNumber0(luckyNumber, winningNumber)).isInstanceOf(IllegalArgumentException.class));
    }
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
