package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.HashSet;
import java.util.List;

import static lotto.utils.Constants.*;

public class LottoValidator {

    public static void validateLotto(List<LottoNumber> numbers) {
        validateLottoSize(numbers.size());
        hasDuplicateLottoNumber(new HashSet<>(numbers).size());
    }

    public static void validateLottoNumber(String lottoNumber) {
        isDigit(lottoNumber);
        isValidLottoNumber(Integer.parseInt(lottoNumber));
    }

    public static void validateWinningLotto(LottoNumber bonusNumber, Lotto winningLotto) {
        if (winningLotto.contain(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_BONUS_NUMBER);
        }
    }

    private static void validateLottoSize(int lottoSize) {
        if (lottoSize != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_LOTTO_SIZE);
        }
    }

    private static void hasDuplicateLottoNumber(int lottoSize) {
        if (lottoSize != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBER);
        }
    }

    public static void validateLottoNumber(int lottoNumber) {
        isValidLottoNumber(lottoNumber);
    }

    private static void isDigit(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT_LOTTO_NUMBER);
        }
    }

    private static void isValidLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || MAX_NUMBER < lottoNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_LOTTO_NUMBER);
        }
    }
}
