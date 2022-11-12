package lotto.exception;

import lotto.resources.ErrorMessage;

import java.util.List;
import java.util.Set;

public class InputException {
    public static void validatePurchaseAmount(String purchaseAmount) {
        try {
            Integer.valueOf(purchaseAmount);
        } catch (Exception exception) {
            System.out.println(ErrorMessage.NOT_NUMBER_ERROR.getErrorMessage());
            throw new IllegalArgumentException();
        }
        if (Integer.valueOf(purchaseAmount) == 0) {
            System.out.println(ErrorMessage.ZERO_WON_ERROR.getErrorMessage());
            throw new IllegalArgumentException();
        }
        if (Integer.valueOf(purchaseAmount) % 1000 != 0) {
            System.out.println(ErrorMessage.UNIT_ERROR.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinningNumber(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            System.out.println(ErrorMessage.SIZE_ERROR.getErrorMessage());
            throw new IllegalArgumentException();
        }
        if (Set.copyOf(winningNumber).size() != 6) {
            System.out.println(ErrorMessage.DUPLICATE_ERROR.getErrorMessage());
            throw new IllegalArgumentException();
        }
        for (Integer number : winningNumber) {
            if (number < 1 || number > 45) {
                System.out.println(ErrorMessage.RANGE_ERROR.getErrorMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_ERROR.getErrorMessage());
        }
    }
}
