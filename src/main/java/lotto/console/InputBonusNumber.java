package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.ErrorPrint;
import lotto.service.NumberChart;

import java.util.List;

public class InputBonusNumber {

    public int getAndVerifyBonusNumber(List<Integer> winningNumbers) {
        String numbers = getBonusNumber();
        verifyItIsNumber(numbers);
        int number = Integer.parseInt(numbers);
        verifyBonusNumberBetween1and45(number);
        verifyBonusNumberDuplicateWinningNumber(winningNumbers, number);

        return number;
    }

    private String getBonusNumber() {
        return Console.readLine();
    }

    private void verifyBonusNumberBetween1and45(int bonusNumber) {
        if (!(NumberChart.MIN_NUMBER.getValue() <= bonusNumber && bonusNumber <= NumberChart.MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException(ErrorPrint.ERROR_1_AND_45.getValue());
        }
    }

    private void verifyBonusNumberDuplicateWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorPrint.ERROR_BONUS_DUPLICATE.getValue());
        }
    }

    private void verifyItIsNumber(String bonusNumber) {
        if (!(bonusNumber.matches(ErrorPrint.REGEX.getValue()))) {
            throw new IllegalArgumentException(ErrorPrint.ERROR_ONLY_NUMBER.getValue());
        }
    }

}
