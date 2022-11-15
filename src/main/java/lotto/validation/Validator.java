package lotto.validation;

import java.util.List;

public class Validator {

    private static final String FIRST_NUMBER_ZERO = "첫 자리는 0을 입력할 수 없습니다.";
    private static final String PATTERN = "^[0-9]+$";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요.";
    private static final String INPUT_THOUSAND_UNIT = "1000원 단위로 입력해주세요.";
    private static final String FROM_ONE_TO_FORTY_FIVE = "1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATION_NUMBER = "중복된 숫자는 입력할 수 없습니다.";
    private static final String INPUT_SIX_NUMBERS = "숫자 6개를 입력해주세요.";
    private static final Character ZERO_NUMBER = '0';
    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;
    private static final int LAST_NUMBER = 45;
    private static final int FIRST_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;


    public static void validateInputMoney(String money) {
        isFirstNumberZero(money);
        isCorrectMoneyPattern(money);
    }

    private static void isFirstNumberZero(String money) {
        if (money.charAt(ZERO) == ZERO_NUMBER) {
            throw new IllegalArgumentException(FIRST_NUMBER_ZERO);
        }
    }

    private static void isCorrectMoneyPattern(String money) {
        if (!money.matches(PATTERN)) {
            throw new IllegalArgumentException(INPUT_NUMBER);
        }
    }

    public static void isDividedByThousand(int money) {
        if (money % THOUSAND != ZERO) {
            throw new IllegalArgumentException(INPUT_THOUSAND_UNIT);
        }
    }

    public static void validateLottoNumber(List<Integer> lottoNumbers) {
        isCorrectSize(lottoNumbers);
        isDuplicatedLottoNumber(lottoNumbers);
        isCorrectRangeLottoNumber(lottoNumbers);
    }

    private static void isCorrectRangeLottoNumber(List<Integer> lottoNumbers) {
        lottoNumbers.forEach(number -> {
            if (number > LAST_NUMBER || number < FIRST_NUMBER) {
                throw new IllegalArgumentException(FROM_ONE_TO_FORTY_FIVE);
            }
        });
    }

    private static void isDuplicatedLottoNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATION_NUMBER);
        }
    }

    private static void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INPUT_SIX_NUMBERS);
        }
    }

    public static void isCorrectBonusNumberPattern(String bonusNumber) {
        if (!bonusNumber.matches(PATTERN)) {
            throw new IllegalArgumentException(INPUT_NUMBER);
        }
    }

    public static void validateBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        isCorrectRangeBonusNumber(bonusNumber);
        isDuplicatedNumber(lottoNumbers, bonusNumber);
    }

    private static void isCorrectRangeBonusNumber(int bonusNumber) {
        if (bonusNumber > LAST_NUMBER || bonusNumber < FIRST_NUMBER) {
            throw new IllegalArgumentException(FROM_ONE_TO_FORTY_FIVE);
        }
    }

    private static void isDuplicatedNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_NUMBER);
        }
    }
}
