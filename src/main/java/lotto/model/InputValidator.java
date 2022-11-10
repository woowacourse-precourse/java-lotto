package lotto.model;

import static lotto.model.Constants.MONEY_MIN_UNIT;
import static lotto.model.NumbersValidator.NUMBER_MAX_VALUE;
import static lotto.model.NumbersValidator.NUMBER_MIN_VALUE;

import java.util.List;

public class InputValidator {

    public static final String INPUT_BONUS_NUMBER_ERROR = "[ERROR] 정확한 보너스 번호가 아닙니다.";
    public static final String INPUT_MONEY_ERROR = "[ERROR] 정확한 금액을 입력해주세요.";
    public static final int MONEY_REST = 0;
    public static final String NUMBER = "^[1-9][0-9]*$";

    private InputValidator() {
    }

    public static boolean isValidTargetLottoNumbers(List<Integer> targetLottoNumbers){
         return NumbersValidator.isValid(targetLottoNumbers);
    }

    public static boolean isValidBonusNumber(Lotto targetLotto, String bonusNumberStr) {
        try {
            isValidDigit(bonusNumberStr);
            int bonusNumber = Integer.parseInt(bonusNumberStr);
            isValidBonusNumberRange(bonusNumber);
            isContainsBonusNumber(targetLotto, bonusNumber);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(INPUT_BONUS_NUMBER_ERROR);
            return false;
        }
    }

    static void isContainsBonusNumber(Lotto targetLotto, int bonusNumber) throws IllegalArgumentException {
        if (targetLotto.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_ERROR);
        }
    }

    static void isValidBonusNumberRange(int bonusNumber)  throws  IllegalArgumentException{
        if (bonusNumber < NUMBER_MIN_VALUE || bonusNumber > NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_ERROR);
        }
    }

    public static boolean isValidMoney(String moneyStr) {
        try {
            isValidDigit(moneyStr);
            int money = Integer.parseInt(moneyStr);
            isValidMoneyRange(money);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(INPUT_MONEY_ERROR);
            return false;
        }
    }

    static void isValidMoneyRange(int money) throws IllegalArgumentException{
        if (money < MONEY_MIN_UNIT || (money % MONEY_MIN_UNIT) != MONEY_REST) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR);
        }
    }

    static void isValidDigit(String moneyStr) throws IllegalArgumentException{
        if (moneyStr == null || moneyStr.isBlank() || !moneyStr.matches(NUMBER)) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR);
        }
    }
}
