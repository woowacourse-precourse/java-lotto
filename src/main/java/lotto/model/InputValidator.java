package lotto.model;

import static lotto.model.Constants.MONEY_MIN_UNIT;
import static lotto.model.Constants.NUMBER;
import static lotto.model.NumbersValidator.NUMBER_MAX_VALUE;
import static lotto.model.NumbersValidator.NUMBER_MIN_VALUE;

import java.util.List;

public class InputValidator {

    public static final String INPUT_BONUS_NUMBER_ERROR = "[ERROR] 정확한 보너스 번호가 아닙니다.";
    public static final String INPUT_MONEY_ERROR = "[ERROR] 정확한 금액을 입력해주세요.";
    public static final int INPUT_MONEY_REST = 0;
    public static final String INPUT_LOTTO_TYPE = "^([1-9][0-9]*)(,[1-9][0-9]*){5}$";

    private InputValidator() {
    }

    public static boolean isValidTargetLottoNumbers(String inputTargetLottoNumbers) {
        try {
            isValidTargetLottoType(inputTargetLottoNumbers);
            List<Integer> targetLottoNumbers = Changer.stringToIntegers(inputTargetLottoNumbers);
            return NumbersValidator.isValid(targetLottoNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }

    }

    private static void isValidTargetLottoType(String inputTargetLottoNumbers) throws IllegalArgumentException {
        if (inputTargetLottoNumbers == null || inputTargetLottoNumbers.isBlank() ||
                !inputTargetLottoNumbers.matches(INPUT_LOTTO_TYPE)) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR);
        }
    }

    public static boolean isValidBonusNumber(Lotto targetLotto, String inputBonusNumberStr) {
        try {
            isValidDigit(inputBonusNumberStr);
            int bonusNumber = Integer.parseInt(inputBonusNumberStr);
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

    static void isValidBonusNumberRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < NUMBER_MIN_VALUE || bonusNumber > NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_ERROR);
        }
    }

    public static boolean isValidMoney(String inputMoney) {
        try {
            isValidDigit(inputMoney);
            int money = Integer.parseInt(inputMoney);
            isValidMoneyRange(money);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(INPUT_MONEY_ERROR);
            return false;
        }
    }

    static void isValidMoneyRange(int money) throws IllegalArgumentException {
        if (money < MONEY_MIN_UNIT || (money % MONEY_MIN_UNIT) != INPUT_MONEY_REST) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR);
        }
    }

    static void isValidDigit(String input) throws IllegalArgumentException {
        if (input == null || input.isBlank() || !input.matches(NUMBER)) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR);
        }
    }
}
