package lotto.util;

import static lotto.advice.ErrorMessage.BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.advice.ErrorMessage.DUPLICATE_ERROR_MESSAGE;
import static lotto.advice.ErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.advice.ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE;
import static lotto.advice.ErrorMessage.MONEY_ERROR_MESSAGE;
import static lotto.constant.LottoNumberConstant.COUNT;
import static lotto.constant.LottoNumberConstant.END;
import static lotto.constant.LottoNumberConstant.START;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.advice.BonusNumberExcption;
import lotto.advice.DuplicateExcption;
import lotto.advice.LottoNumberExcption;
import lotto.advice.LottoSizeExcption;
import lotto.advice.MoneyException;

public class Validator {

    private final Pattern pattern = Pattern.compile("^[0-9]*$");

    public void validateLottoNumber(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new LottoNumberExcption(LOTTO_NUMBER_ERROR_MESSAGE);
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new DuplicateExcption(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void validateWinningNumber(String[] winningNumber) {
        if (Arrays.stream(winningNumber).distinct().count() != winningNumber.length) {
            throw new DuplicateExcption(DUPLICATE_ERROR_MESSAGE);
        }
        if (winningNumber.length != COUNT) {
            throw new LottoSizeExcption(LOTTO_SIZE_ERROR_MESSAGE);
        }
        for (String number : winningNumber) {
            number = number.trim();
            validateLottoNumber(number);
            if (!isRangeNumber(Integer.valueOf(number))) {
                throw new LottoNumberExcption(LOTTO_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private void validateLottoNumber(String number) {
        if (!isNumber(number)) {
            throw new LottoNumberExcption(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    public void validateMoney(String moeny) {
        if (!isNumber(moeny)) {
            throw new MoneyException(MONEY_ERROR_MESSAGE);
        }
        if (Integer.parseInt(moeny) % 1000 != 0) {
            throw new MoneyException(MONEY_ERROR_MESSAGE);
        }
    }

    public void validateBonusNumber(String bonumsNumber) {
        if (!isNumber(bonumsNumber)) {
            throw new BonusNumberExcption(BONUS_NUMBER_ERROR_MESSAGE);
        }

        if (!isRangeNumber(Integer.parseInt(bonumsNumber))) {
            throw new BonusNumberExcption(BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean isNumber(String number) {
        return pattern.matcher(number).find();
    }

    private boolean isRangeNumber(int number) {
        return number >= START && number <= END;
    }
}
