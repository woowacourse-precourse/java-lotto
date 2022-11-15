package Exception;

import java.util.List;

public class Invalidator {

    public static int isValidPurchaseAmount(String inputValue) throws ProcessException {
        if (!isNumeric(inputValue)) {
            throw new ProcessException("[ERROR]");
        }
        int inputNumber = Integer.parseInt(inputValue);

        if (inputNumber == 0) {
            throw new ProcessException("[ERROR] 구매 금액은 0보다 커야합니다.");
        }
        if (inputNumber % 1000 != 0) {
            throw new ProcessException("[ERROR] 구매 금액은 1000단위로 입력해야 합니다.");
        }
        return inputNumber;
    }

    public static int isValidBonusNumber(int bonusNumber, List<Integer> winningLotto) throws ProcessException {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new ProcessException("[ERROR] 올바르지 않은 보너스 번호입니다.");
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new ProcessException("[ERROR] 올바르지 않은 보너스 번호입니다.");
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
