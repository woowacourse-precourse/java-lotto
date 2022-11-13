package lotto.exception;

import lotto.resources.ErrorMessage;

import java.util.List;
import java.util.Set;

public class InputException {
    private static final int THOUSAND_WON = 1000;
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

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
        if (Integer.valueOf(purchaseAmount) % THOUSAND_WON != 0) {
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
            if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
                System.out.println(ErrorMessage.RANGE_ERROR.getErrorMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        if (bonusNumber < LOTTO_FIRST_NUMBER || bonusNumber > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_ERROR.getErrorMessage());
        }
    }
}
