package lotto.model;

import static lotto.model.Changer.StringToIntegers;

import java.util.List;

class InputValidator {

    public static final String BONUS_NUMBER_ERROR = "정확한 보너스 번호가 아닙니다.";

    public static void isValid(String input) {
        List<Integer> list = StringToIntegers(input);
        NumbersValidator.isValid(list);
    }

    public static void isValidBonusNumber(String targetLotto, String bonusNumber) {
        List<Integer> lottoNumbers = StringToIntegers(targetLotto);
        Integer bonusNum = Integer.valueOf(bonusNumber);
        if (lottoNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }
}
