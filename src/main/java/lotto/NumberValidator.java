package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberValidator {
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자로 이루어진 금액을 입력해야 합니다.";
    private static final String INVALID_PURCHASE_PRICE_ERROR_MESSAGE = "[ERROR] 로또 금액은 1000원 단위로 입력해야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자로 입력해야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_FORM_ERROR_MESSAGE = "[ERROR] 로또 번호는 ,(콤마)로 구분해야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개 이어야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    private static final String DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 로또 번호와 중복되지 않아야 합니다.";

    private static final String MATCHER = "[+-]?\\d*(\\.\\d+)?";
    private static final String DELIMITER = ",";

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int ONE_LOTTO_PRICE = 1000;

    public static void isValidPurchasePrice(String lottoPrice) {
        isNumber(lottoPrice);
        isValidPrice(lottoPrice);
    }

    private static void isNumber(String number) {
        if (!number.matches(MATCHER)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void isValidPrice(String lottoPrice) {
        if (Integer.parseInt(lottoPrice) % ONE_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_PRICE_ERROR_MESSAGE);
        }
    }

    public static void isValidLottoNumbers(String lottoNumbers) {
        isValidLottoNumber(lottoNumbers);
        isValidLottoNumberForm(lottoNumbers);
        isValidLottoNumberCount(lottoNumbers);
        isValidLottoNumberRange(lottoNumbers);
        isDuplicatedLottoNumbers(lottoNumbers);
    }

    private static void isValidLottoNumber(String lottoNumbers) {
        List<String> numbers = Arrays.stream(lottoNumbers.split(DELIMITER))
                .collect(Collectors.toList());

        for (String number : numbers) {
            if (!number.matches(MATCHER)) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private static void isValidLottoNumberForm(String lottoNumbers) {
        if (!lottoNumbers.contains(DELIMITER)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORM_ERROR_MESSAGE);
        }
    }

    private static void isValidLottoNumberCount(String lottoNumbers) {
        List<String> numbers = Arrays.stream(lottoNumbers.split(DELIMITER))
                .collect(Collectors.toList());

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private static void isValidLottoNumberRange(String lottoNumbers) {
        List<Integer> numbers = LottoGame.spiltLottoNumber(lottoNumbers);

        for (int number : numbers) {
            if (!isBetween(number)) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private static boolean isBetween(int number) {
        return (number >= LOTTO_START_NUMBER) && (number <= LOTTO_END_NUMBER);
    }

    private static void isDuplicatedLottoNumbers(String lottoNumbers) {
        Set<String> duplicated = Arrays.stream(lottoNumbers.split(DELIMITER)).collect(Collectors.toSet());

        if (duplicated.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void isValidBonusNumber(String bonusNumber, String winningLottoNumber) {
        isValidNumber(bonusNumber);
        isValidBonusNumberRange(bonusNumber);
        isDuplicateWithLottoNumbers(bonusNumber, winningLottoNumber);
    }

    private static void isValidNumber(String bonusNumber) {
        if (!bonusNumber.matches(MATCHER)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void isValidBonusNumberRange(String bonusNumber) {
        if (!isBetween(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static void isDuplicateWithLottoNumbers(String bonusNumber, String winningLottoNumber) {
        List<String> numbers = Arrays.stream(winningLottoNumber.split(DELIMITER))
                .collect(Collectors.toList());

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }
}
