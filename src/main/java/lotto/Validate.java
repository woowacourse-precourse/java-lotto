package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    private static final String INPUT_LOTTO_PATTERN = "^([1-9]\\d?,){5}[1-9]\\d?$";
    private static final String ONLY_NUMBER_PATTERN = "^\\d*$";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String NOT_SIX_LOTTO_NUMBER_MESSAGE = "로또 숫자가 로또 숫자가 6개가 아닙니다.";
    private static final String HAVE_DUPLICATE_NUMBER_MESSAGE = "중복된 번호가 있습니다.";
    private static final String BONUS_NUMBER_DUPLICATE_MESSAGE = "당첨번호와 보너스 번호는 달라야 합니다.";
    private static final String INPUT_LOTTO_MESSAGE = "숫자와 ,만 입력해 주세요.";
    private static final String ONLY_NUMBER_MESSAGE = "숫자만 입력해 주세요.";
    private static final String LOTTO_MINIMUM_PRICE_MESSAGE = "1,000원 이상을 입력해 주세요.";
    private static final String LOTTO_PRICE_RULE_MESSAGE = "1,000원으로 나누어 떨어지는 금액만 입력해 주세요.";
    private static final String LOTTO_NUMBER_RANGE_RULE_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";


    public static void lottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_SIX_LOTTO_NUMBER_MESSAGE);
        }
    }

    public static void lottoDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + HAVE_DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public static void bonusNumberBelongsNumber(Lotto lottoNumber, Integer bonusNumber) {
        List<Integer> number = lottoNumber.getNumbers();
        if (number.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    public static void findOnlyNumber(String input, String bonusNumber) {
        if (!input.matches(INPUT_LOTTO_PATTERN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_LOTTO_MESSAGE);
        }

        if (!bonusNumber.matches(ONLY_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ONLY_NUMBER_MESSAGE);
        }
    }


    public static int isInteger(String input) {
        if (input.matches(ONLY_NUMBER_PATTERN)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + ONLY_NUMBER_MESSAGE);
    }

    public static void canBuyLotto(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_MINIMUM_PRICE_MESSAGE);
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_PRICE_RULE_MESSAGE);
        }
    }

    public static void inRangeLottoNumber(Integer lottoNumber) {
        if (lottoNumber >= 1 && lottoNumber <= 45) {
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_NUMBER_RANGE_RULE_MESSAGE);
    }
}
