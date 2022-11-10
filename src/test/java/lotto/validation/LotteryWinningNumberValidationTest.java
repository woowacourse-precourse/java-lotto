package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.IntConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryWinningNumberValidationTest {

    @DisplayName("당첨번호의 개수가 다른 입력이라면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notCorrectCountLotteryNumberWithOverCount() {
        LotteryWinningNumberValidation lotteryWinningNumberValidation = new LotteryWinningNumberValidation();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < IntConstant.LOTTO_NUMBER_COUNT.getValue() + 2; i++) {
            stringBuilder.append(i);
            if (i + 1 < IntConstant.LOTTO_NUMBER_COUNT.getValue() + 2) {
                stringBuilder.append(',');
            }
        }
        String userInput = stringBuilder.toString();
        assertThrows(IllegalArgumentException.class, () -> lotteryWinningNumberValidation.isValidate(userInput));
    }


    @DisplayName("당첨번호의 개수가 다른 입력이라면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notCorrectCountLotteryNumberWithLessCount() {
        LotteryWinningNumberValidation lotteryWinningNumberValidation = new LotteryWinningNumberValidation();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < IntConstant.LOTTO_NUMBER_COUNT.getValue(); i++) {
            stringBuilder.append(i);
            if (i + 1 < IntConstant.LOTTO_NUMBER_COUNT.getValue()) {
                stringBuilder.append(',');
            }
        }
        String userInput = stringBuilder.toString();
        assertThrows(IllegalArgumentException.class, () -> lotteryWinningNumberValidation.isValidate(userInput));
    }

    @DisplayName("당첨 번호 숫자가 올바른 범위의 숫자가 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void lotteryWinningNumberNumeric() {
        LotteryWinningNumberValidation lotteryWinningNumberValidation = new LotteryWinningNumberValidation();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < IntConstant.LOTTO_NUMBER_COUNT.getValue(); i++) {
            stringBuilder.append(i);
            if (i + 1 < IntConstant.LOTTO_NUMBER_COUNT.getValue()) {
                stringBuilder.append(',');
            }
        }
        String userInput = stringBuilder.toString();
        assertThrows(IllegalArgumentException.class, () -> lotteryWinningNumberValidation.isValidate(userInput));
    }

}