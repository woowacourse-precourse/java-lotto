package Exception;

import java.util.List;

import static Exception.ErrorMessage.*;

public class Invalidator {

    public static int isValidPurchaseAmount(String inputValue) throws ProcessException {
        if (!isNumeric(inputValue)) {
            throw new ProcessException(ERROR_HEADER.getMsg() + ERROR_PURCHASED_DATAFORMAT.getMsg());
        }
        int inputNumber = Integer.parseInt(inputValue);

        if (inputNumber == 0) {
            throw new ProcessException(ERROR_HEADER.getMsg() + ERROR_PURCHASED_RANGE.getMsg());
        }
        if (inputNumber % 1000 != 0) {
            throw new ProcessException(ERROR_HEADER.getMsg() + ERROR_PURCHASED_UNIT);
        }
        return inputNumber;
    }

    public static int isValidBonusNumber(int bonusNumber, List<Integer> winningLotto) throws ProcessException {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new ProcessException(ERROR_HEADER.getMsg() + ERROR_BONUS_RANGE.getMsg());
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new ProcessException(ERROR_HEADER.getMsg() + ERROR_BONUS_DUPLICATE.getMsg());
        }
        return bonusNumber;
    }
    private static boolean isNumeric(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
