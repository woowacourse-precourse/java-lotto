package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {
    public static final String ERROR_MESSAGE_NOT_VALID_LOTTO_SIZE = "[ERROR] 로또 번호는 단 6개만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복된 숫자를 포함해서는 안됩니다.";
    public static final String ERROR_MESSAGE_NOT_DIGIT = "[ERROR] 로또 번호는 숫자만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_LOTTO_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 숫자는 당첨 번호와 중복되어서는 안됩니다.";

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
        if (lottoSize != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_LOTTO_SIZE);
        }
    }

    private static void hasDuplicateLottoNumber(int lottoSize) {
        if (lottoSize != Lotto.LOTTO_SIZE) {
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
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT);
        }
    }

    private static void isValidLottoNumber(int lottoNumber) {
        if (lottoNumber < Lotto.MIN_NUMBER || Lotto.MAX_NUMBER < lottoNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_LOTTO_NUMBER);
        }
    }
}
