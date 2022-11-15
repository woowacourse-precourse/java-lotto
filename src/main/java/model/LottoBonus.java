package model;

import java.util.List;

public class LottoBonus {
    private static int bonusNumber;

    public LottoBonus(String input, List<Integer> winningNumber) {
        validateRange(input);
        validateDuplication(input, winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateRange(String input) {
        bonusNumber = Integer.parseInt(input);

        if (bonusNumber > LottoConstant.MAX_LOTTO_NUMBER.getNumber() || bonusNumber < LottoConstant.MIN_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.OVERRANGE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public void validateDuplication(String input, List<Integer> winningNumber) {
        bonusNumber = Integer.parseInt(input);

        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_MESSAGE.getErrorMessage());
        }
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }
}

