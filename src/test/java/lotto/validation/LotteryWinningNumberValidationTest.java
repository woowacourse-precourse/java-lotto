package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.IntConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryWinningNumberValidationTest {
    Validation lotteryWinningNumberValidation = new LotteryWinningNumberValidation();
    @DisplayName("당첨번호의 개수가 다른 입력이라면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notCorrectCountLotteryNumberWithOverCount() {
        String userInput = createUserInputWithLength(1, IntConstant.LOTTO_NUMBER_COUNT.getValue() + 1);
        assertThrows(IllegalArgumentException.class, () -> lotteryWinningNumberValidation.isValidate(userInput));
    }


    @DisplayName("당첨번호의 개수가 다른 입력이라면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notCorrectCountLotteryNumberWithLessCount() {
        String userInput = createUserInputWithLength(1, IntConstant.LOTTO_NUMBER_COUNT.getValue() - 1);
        assertThrows(IllegalArgumentException.class, () -> lotteryWinningNumberValidation.isValidate(userInput));
    }

    @DisplayName("당첨번호가 Numeric 형태가 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notCorrectForm() {
        String userInput = createUserInputWithLength(-1, IntConstant.LOTTO_NUMBER_COUNT.getValue());
        assertThrows(IllegalArgumentException.class, () -> lotteryWinningNumberValidation.isValidate(userInput));
    }

    @DisplayName("당첨 번호 숫자가 올바른 범위의 숫자가 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void lotteryWinningNumberNumeric() {
        String userInput = createUserInputWithLength(IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue(),
                IntConstant.LOTTO_NUMBER_COUNT.getValue());
        assertThrows(IllegalArgumentException.class, () -> lotteryWinningNumberValidation.isValidate(userInput));
    }

    @DisplayName("올바른 winning number 일 경우 오류를 내지 않는다.")
    @Test
    void successWinningNumber() {
        String userInput = createUserInputWithLength(IntConstant.LOTTO_NUMBER_BIGGER_THAN.getValue(),
                IntConstant.LOTTO_NUMBER_COUNT.getValue());
        System.out.println("userInput = " + userInput);
        assertDoesNotThrow(() -> lotteryWinningNumberValidation.isValidate(userInput));
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

}