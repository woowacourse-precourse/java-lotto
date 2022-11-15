package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.MessageConstant.*;

public class Validate {
    private static final int LOTTO_SIZE = 6;
    private static final int MINIMUM_LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final String INPUT_LOTTO_PATTERN = "^([1-9]\\d?,){5}[1-9]\\d?$";
    private static final String ONLY_NUMBER_PATTERN = "^\\d*$";
    public static void lottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_SIX_LOTTO_NUMBER_MESSAGE);
        }
    }

    public static void lottoDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
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
        if (money < MINIMUM_LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_MINIMUM_PRICE_MESSAGE);
        }

        if (money % MINIMUM_LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_PRICE_RULE_MESSAGE);
        }
    }

    public static void inRangeLottoNumber(Integer lottoNumber) {
        if (lottoNumber >= MINIMUM_LOTTO_NUMBER && lottoNumber <= MAXIMUM_LOTTO_NUMBER) {
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_NUMBER_RANGE_RULE_MESSAGE);
    }
}
