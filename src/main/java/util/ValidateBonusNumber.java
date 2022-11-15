package util;

import constant.ErrorMessage;
import java.util.List;
import view.InputWinningLottoNumber;

public class ValidateBonusNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    static int bonusNumber;

    public static int validateBonusNumber(String inputBonusNumber) {
        int bonusNumber = 0;
        bonusNumber = convertInteger(inputBonusNumber);

        isInRange(bonusNumber);

        isBonusNumberInWinningTicket(bonusNumber);
        return bonusNumber;

    }

    private static int convertInteger(String inputBonusNumber) {

        try {
            bonusNumber = Integer.parseInt(inputBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NOT_NUMBER.getMessage());
        }
        return bonusNumber;
    }

    private static void isInRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_OVERRANGE.getMessage());
        }
    }

    public static void isBonusNumberInWinningTicket(int bonusNumber) {
        List<Integer> lottoTicket = InputWinningLottoNumber.getWinningLottoTicket();
        int rightBonusNumber = bonusNumber;
        if (lottoTicket.stream().anyMatch(n -> rightBonusNumber == n)) {
            throw new IllegalArgumentException(
                ErrorMessage.ERROR_BONUS_DUPLICATE_WINNING.getMessage());
        }
    }


}
