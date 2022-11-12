package view;

import camp.nextstep.edu.missionutils.Console;
import constant.ErrorMessage;
import java.util.List;

public class InputBonusNumber {



    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    static int bonusNumber;

    public static void inputBonusNumber() {
        OutputView.printInputBonus();
        String inputBonusNumber = Console.readLine();
        validateBonusNumber(inputBonusNumber);
    }

    public static void validateBonusNumber(String inputBonusNumber) {
        int bonusNumber = 0;
        bonusNumber = convertInteger(inputBonusNumber);

        isInRange(bonusNumber);

        isBonusNumberInWinningTicket(bonusNumber);

    }

    private static int convertInteger(String inputBonusNumber) {

        try {
            bonusNumber = Integer.parseInt(inputBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NOTNUMBER.getMessage());
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

    public static int getBonusNumber() {
        return bonusNumber;
    }
}
