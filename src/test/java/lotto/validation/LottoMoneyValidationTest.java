package lotto.validation;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.constant.IntConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyValidationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("숫자가 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notNumberException() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }

    @DisplayName("정수형이 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notIntegerInputException() {
        assertSimpleTest(() -> {
            runException("12.3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("음수 값이면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void minusValueException() {
        assertSimpleTest(() -> {
            runException("-2100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }

    @DisplayName("로또 1개 가격으로 나누어 떨어지지 않으면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notDivideByLottoMoneyPerCountInputException() {
        assertSimpleTest(() -> {
            runException(String.valueOf(IntConstant.LOTTO_MONEY_PER_ONE.getValue() / 10));
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }

    @DisplayName("모두 통과하면 어떠한 상황도 발생하지 않는다.")
    @Test
    void correctMoneyInput() {
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}