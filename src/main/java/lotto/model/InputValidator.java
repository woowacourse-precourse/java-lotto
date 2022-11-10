package lotto.model;

import static lotto.model.Changer.StringToIntegers;

import java.util.List;

class InputValidator {
    public static void isValid(String input) {
        List<Integer> list = StringToIntegers(input);
        NumbersValidator.isValid(list);
    }

    public static boolean isValidBonusNumber(String targetLotto, String bonusNumber) {
        List<Integer> lottoNumbers = StringToIntegers(targetLotto);
        Integer bonusNum = Integer.valueOf(bonusNumber);
        return lottoNumbers.contains(bonusNum);
    }
}
