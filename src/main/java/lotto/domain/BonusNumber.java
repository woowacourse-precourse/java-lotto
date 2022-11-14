package lotto.domain;

import lotto.view.ErrorMessage;

import java.util.List;

public class BonusNumber {
  public static void isOnlyDigitBonusNumber(String bonusNumber) {
    for (int i = 0; i < bonusNumber.length(); i++) {
      if (!Character.isDigit(bonusNumber.charAt(i))) {
        throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_DIGIT.getMessage());
      }
    }
  }
  public static void isInRangeBonusNumber(String bonusNumber) {
    isOnlyDigitBonusNumber(bonusNumber);
    int numbers = Integer.parseInt(bonusNumber);
    if (numbers < 1 || numbers > 45) {
      throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_MESSAGE.getMessage());
    }
  }

  public static int validBonusNumber(String bonusNumber, List<Integer> winningNumber) {
    isInRangeBonusNumber(bonusNumber);
    int validBonusNumber = Integer.parseInt(bonusNumber);
    if (winningNumber.contains(validBonusNumber))
      throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_NUMBER.getMessage());
    return validBonusNumber;
  }
}
