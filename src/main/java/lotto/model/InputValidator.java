package lotto.model;

import static lotto.model.Changer.StringToIntegers;
import static lotto.model.NumbersValidator.NUMBER_MAX_VALUE;
import static lotto.model.NumbersValidator.NUMBER_MIN_VALUE;

import java.util.List;

class InputValidator {

    public static final String BONUS_NUMBER_ERROR = "정확한 보너스 번호가 아닙니다.";

    public static void isValid(String input) {
        List<Integer> list = StringToIntegers(input);
        NumbersValidator.isValid(list);
    }

    public static void isValidMoney(String targetLotto,String input) {
        isValidBonusNumberRange(input);
        isContainsBonusNumber(targetLotto, input);
    }

    public static void isContainsBonusNumber(String targetLotto, String bonusNumber) {
        List<Integer> lottoNumbers = StringToIntegers(targetLotto);
        Integer bonusNum = Integer.valueOf(bonusNumber);
        if (lottoNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }

    public static void isValidBonusNumberRange(String bonusNumberStr) {
        int bonusNumber = Integer.parseInt(bonusNumberStr);
        if (bonusNumber < NUMBER_MIN_VALUE || bonusNumber > NUMBER_MAX_VALUE ) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }
}
