package lotto.exception;

import static lotto.domain.Constant.ERROR_MESSAGE;
import static lotto.domain.Constant.MAX_LOTTO_NUMBER;
import static lotto.domain.Constant.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Constant;

public class LuckyLottoNumberException {

    public void checkLuckyLottoNumberExceptions(List<Integer> inputLuckyNumbers) {
        checkDuplicatedLottoNumber(inputLuckyNumbers);
        checkLottoNumberBetweenOneAndFortyFive(inputLuckyNumbers);
    }

    public void checkLottoBonusNumberExceptions(List<Integer> inputLuckyNumbers, int bonusLottoNumber) {
        checkLottoBonusNumberBetweenOneAndFortyFive(bonusLottoNumber);
        checkDuplicatedLottoBonusNumber(inputLuckyNumbers, bonusLottoNumber);
    }



}
