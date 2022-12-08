package lotto;

import lotto.Exception.Exception;

import java.util.List;

public class WinningLottoChecker {
    public static List checkAndConvertLotto(String lottoNumbers) {
        String[] numberArray = TextConverter.splitComma(lottoNumbers);
        List lottoNumberList = ArrayConverter.toIntegerList(numberArray);
        return lottoNumberList;
    }

    public static int checkAndConvertBonus(String stringBonusNumber) {
        isValidBonusNumber(stringBonusNumber);
        int bonusNumber = Integer.parseInt(stringBonusNumber);
        return bonusNumber;
    }

    private static void isValidBonusNumber(String bonusNumber) {
        Exception.isNum(bonusNumber);
        Exception.checkRange(Integer.parseInt(bonusNumber));
    }
}
