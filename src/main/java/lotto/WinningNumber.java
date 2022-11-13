package lotto;

import lotto.ENUMS.ErrorMessages;
import lotto.ENUMS.LotteryRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    List<Integer> winningNumber = new ArrayList<>();
    int bonusNumber;

    WinningNumber(String input, String bonusNumber) {
        validateNumber(input, bonusNumber);
        setNumbers(input, bonusNumber);
    }

    public void setNumbers(String input, String bonusNumber) {
        String[] splitInput = input.split(",");
        for (String num : splitInput) {
            winningNumber.add(Integer.parseInt(num));
        }
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateNumber(String input, String bonusNumber) {
        String[] splitInput = input.split(",");
        if (splitInput.length != LotteryRules.COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_SIGN.getErrorMessage()
                    + " " + ErrorMessages.COUNT_ERROR.getErrorMessage());
        }
        Set<Integer> checkDup = new HashSet<>();
        for (String num : splitInput) {
            checkDup.add(Integer.parseInt(num));
        }
        checkDup.add(Integer.parseInt(bonusNumber));


        if (checkDup.size() != LotteryRules.COUNT.getNumber() + 1) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_SIGN.getErrorMessage()
                    + " " + ErrorMessages.DUPLICATE_ERROR.getErrorMessage());
        }
    }
}
