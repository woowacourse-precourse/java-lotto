package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
    public List<Integer> luckySix;
    public int luckyBonus;

    public static checkluckySix

    private void validateLuckySix(List<Integer> luckySix) {
        Lotto luckySixValidation = new Lotto(luckySix);
    }

    private void validateBonusNumber() {
        for (int index = 0; index < inputBonusNumber.length(); index++) {
            if (!Character.isDigit(inputBonusNumber.charAt(index))) {
                throw new IllegalArgumentException(GameMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
            if (index == 1) {
                throw new IllegalArgumentException(GameMessage.BONUS_ERROR_MESSAGE.getMessage());
            }
            if (luckySix.contains(Character.getNumericValue(inputBonusNumber.charAt(index)))) {
                throw new IllegalArgumentException(GameMessage.LUCKY_DUPLICATE_ERROR_MESSAGE.getMessage());
            }
            luckyBonus = Character.getNumericValue(inputBonusNumber.charAt(index));
        }
    }

    private List<Integer> convertStringToList(String luckySixInput) {
        List<Integer> tempLuckySix = new ArrayList<>();
        for (int index = 0; index < luckySixInput.length(); index++) {
            char oneNumber = luckySixInput.charAt(index);
            if (oneNumber == ',') {
                continue;
            }
            if (!Character.isDigit(oneNumber)) {
                throw new IllegalArgumentException(GameMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
            tempLuckySix.add(Character.getNumericValue(oneNumber));
        }
        return tempLuckySix;
    }

    private int convertStringToInteger(String luckyBonusInput) {
        if (!Character.isDigit(luckyBonusInput.get)) {
            throw new IllegalArgumentException(GameMessage.INTEGER_ERROR_MESSAGE.getMessage());
        }
        return Integer.parseInt(luckyBonusInput);
    }
}
