package lotto.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Test;
import lotto.constant.IntConstant;
import org.junit.jupiter.api.DisplayName;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class LottoValidationTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("당첨번호의 개수가 다른 입력이라면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notCorrectCountLotteryNumberWithOverCount() {
        String userInput = createUserInputWithLength(1, IntConstant.LOTTO_NUMBER_COUNT.getValue() + 1);
        assertSimpleTest(() -> {
            runException("8000", userInput);
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }
    @DisplayName("당첨번호의 개수가 다른 입력이라면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notCorrectCountLotteryNumberWithLessCount() {
        String userInput = createUserInputWithLength(1, IntConstant.LOTTO_NUMBER_COUNT.getValue() - 1);
        assertSimpleTest(() -> {
            runException("8000", userInput);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
//
    @DisplayName("당첨번호가 Numeric 형태가 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notCorrectForm() {
        String userInput = createUserInputWithLength(-1, IntConstant.LOTTO_NUMBER_COUNT.getValue());
        assertSimpleTest(() -> {
            runException("8000", userInput);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 숫자가 올바른 범위의 숫자가 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void lotteryWinningNumberNumeric() {
        String userInput = createUserInputWithLength(IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue(),
                IntConstant.LOTTO_NUMBER_COUNT.getValue());
        assertSimpleTest(() -> {
            runException("8000", userInput);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 숫자가 overlapping 되면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void lotteryWinningNumberOverlapping() {
        String userInput = "1,2,3,4,5,5";
        assertSimpleTest(() -> {
            runException("8000", userInput);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("올바른 winning number 일 경우 오류를 내지 않는다.")
    @Test
    void successWinningNumber() {
        assertDoesNotThrow(() -> run("8000", "1,2,3,4,5,6", "7"));
    }

    /**
     * String consists of String starts with(start with number) ascending with length (length number)
     * ex) (1,2) -> 1,2
     * ex) (2,3) -> 2,3,4
     * first parameter : start with
     * second parameter : length
     */
    private static String createUserInputWithLength(int start, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i < start + length; i++) {
            stringBuilder.append(i);
            if (i + 1 < start + length) {
                stringBuilder.append(',');
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}