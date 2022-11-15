package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckInput {
    public static final String ERROR_INVALID_NUMBER_TYPE = "[ERROR] 숫자이외의 값이 포함되어 있습니다.";
    public static final String ERROR_INVALID_LOTTO_LENGTH = "[ERROR] 입력되는 로또값은 6자리여야 합니다.";
    public static final String ERROR_INVALID_NUMBER_RANGE = "[ERROR] 입력은 0보다 커야합니다.";
    public static final String ERROR_INVALID_NUMBER_PRICE_TYPE = "[ERROR] 1,000 단위로만 입력할 수 있습니다.";
    public static final String ERROR_INVALID_LOTTO_RANGE = "[ERROR] 당첨번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_INVALID_LOTTO_DUPLICATION = "[ERROR] 로또 값이 중복되지 않아야 합니다.";
    public static final String ERROR_INVALID_SAME_LOTTO_BONUS = "[ERROR] 입력한 로또 번호와 보너스 번호가 중복됩니다.";

    public static void checkInputMoney(String input) {
        if (isNumeric(input))
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_TYPE);

        if (!(Integer.parseInt(input) > 0))
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_RANGE);

        if (Integer.parseInt(input) % 1000 != 0)
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_PRICE_TYPE);
    }

    public static void checkInputLotto(String input) {
        if (isNumeric(input))
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_TYPE);
        if (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 45)
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_RANGE);
    }

    public static void checkInputLottoLength(List<Integer> value) {
        if (!(value.size() == 6))
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_LENGTH);
    }

    public static void checkInputLottoDuplicate(List<Integer> value) {
        Set<Integer> numSet = new HashSet<>(value);

        if (numSet.size() != value.size())
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_DUPLICATION);
    }

    public static boolean isNumeric(String s) {
        return s == null || !s.matches("[-+]?\\d*\\.?\\d+");
    }
}

