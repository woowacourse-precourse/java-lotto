package lotto.model;

import static lotto.model.Changer.StringToIntegers;
import static lotto.model.Constants.MONEY_MIN_UNIT;
import static lotto.model.NumbersValidator.NUMBER_MAX_VALUE;
import static lotto.model.NumbersValidator.NUMBER_MIN_VALUE;

import java.util.List;

class InputValidator {

    public static final String INPUT_BONUS_NUMBER_ERROR = "[ERROR] 정확한 보너스 번호가 아닙니다.";
    public static final String INPUT_MONEY_ERROR = "[ERROR] 정확한 금액을 입력해주세요.";
    public static final int MONEY_REST = 0;

    private InputValidator() {
    }

    public static void isValid(String input) {
        List<Integer> list = StringToIntegers(input);
        NumbersValidator.isValid(list);
    }

    public static void isValidBonusNumber(String targetLotto, String input) {
        isValidBonusNumberRange(input);
        isContainsBonusNumber(targetLotto, input);
    }

    public static void isContainsBonusNumber(String targetLotto, String bonusNumber) {
        List<Integer> lottoNumbers = StringToIntegers(targetLotto);
        Integer bonusNum = Integer.valueOf(bonusNumber);
        if (lottoNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_ERROR);
        }
    }

    public static void isValidBonusNumberRange(String bonusNumberStr) {
        int bonusNumber = Integer.parseInt(bonusNumberStr);
        if (bonusNumber < NUMBER_MIN_VALUE || bonusNumber > NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_ERROR);
        }
    }

    public static void isValidMoney(String moneyStr) {
        int money = Integer.parseInt(moneyStr);
        if (money < MONEY_MIN_UNIT || money % MONEY_MIN_UNIT != MONEY_REST) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR);
        }
    }
}
