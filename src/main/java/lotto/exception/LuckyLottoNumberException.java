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

    public void checkDuplicatedLottoNumber(List<Integer> inputLuckyNumbers) {
        Set<Integer> inputLuckyNumbersBundle = new HashSet<>();
        for (int i = 0; i < inputLuckyNumbers.size(); i++) {
            inputLuckyNumbersBundle.add(inputLuckyNumbers.get(i));
        }
        if (inputLuckyNumbersBundle.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + "중복된 숫자가 있습니다.");
        }
    }

    public void checkLottoNumberBetweenOneAndFortyFive(List<Integer> inputLuckyNumbers) {
        for (int inputLuckyNumber : inputLuckyNumbers) {
            if (inputLuckyNumber > Constant.MAX_LOTTO_NUMBER || inputLuckyNumber < Constant.MIN_LOTTO_NUMBER) {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE + "로또의 범위 밖에 벗어났습니다.");
            }
        }
    }

    public void checkDuplicatedLottoBonusNumber(List<Integer> inputLuckyNumbers, int bonusLottoNumber) {
        if (inputLuckyNumbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + "보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public void checkLottoBonusNumberBetweenOneAndFortyFive(int bonusLottoNumber) {
        if (bonusLottoNumber > Constant.MAX_LOTTO_NUMBER || bonusLottoNumber < Constant.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + "로또의 범위 밖에 벗어났습니다.");
        }
    }

}
