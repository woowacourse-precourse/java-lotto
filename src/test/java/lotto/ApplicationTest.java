package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.exception.MyIllegalArgumentException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("음수인 금액이 입력되었을 때 예외처리하는지 확인한다.")
    void askAmountByNegativeValue() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("1000으로 나눠지지 않는 금액이 입력되었을 때 예외처리하는지 확인한다.")
    void askAmountByNotDevidedValue() {
        assertSimpleTest(() -> {
            runException("1400");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"가,나,다,라,마,바", "가나다라마바"})
    @DisplayName("당첨 번호를 규칙에 어긋나게 입력했을 때 예외처리하는지 확인한다.")
    void askWinNumbersByErrorInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Assertions.assertThatThrownBy(Application::askWinNumbers)
                .isInstanceOf(MyIllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호를 올바르게 입력했을 때 리스트를 반환하는지 확인한다.")
    void askWinNumbers() {
        String input = "1,2,3,4,5,6";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        List<Integer> numbers = Application.askWinNumbers();
        Assertions.assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("보너스 번호를 잘못 입력했을 때 예외 처리하는지 확인한다.")
    void askBonusNumberByErrorInput() {
        String input = "가";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Assertions.assertThatThrownBy(Application::askBonusNumber)
                .isInstanceOf(MyIllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호를 올바르게 입력했을 때 숫자를 반환하는지 확인한다.")
    void askBonusNumber() {
        String input = "10";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Assertions.assertThat(Application.askBonusNumber()).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"2000,4000000000,200000000.0", "8000,5000,62.5"})
    @DisplayName("보너스 번호를 올바르게 입력했을 때 숫자를 반환하는지 확인한다.")
    void printProfit(long money, long totalMoney, double profit) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Application.printProfit(money, totalMoney);
        Assertions.assertThat(output.toString()).isEqualTo("총 수익률은 " + profit + "%입니다.\n");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
