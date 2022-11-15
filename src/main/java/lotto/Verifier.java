package lotto;

import java.util.ArrayList;
import java.util.List;

public class Verifier {
    public static void validateMoney(String value) {
        validateInteger(value);
        int money = Integer.parseInt(value);
        if (money < Lotto.PRICE || (money % Lotto.PRICE) != 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_MONEY.getMessage());
        }
    }

    public static void validateWinningNumbers(String[] values) {
        if (values.length != Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorType.NUMBER_COUNT.getMessage());
        }
        validateDuplicate(values);
        for (String value : values) {
            validateLottoNumber(value);
        }
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validateLottoNumber(bonusNumber);
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorType.HAS_DUPLICATE.getMessage());
        }
    }

    public static void validateLottoNumber(String value) {
        validateInteger(value);
        int number = Integer.parseInt(value);
        if (number < Lotto.START_RANGE || number > Lotto.END_RANGE) {
            throw new IllegalArgumentException(ErrorType.OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateDuplicate(String[] values) {
        List<String> temp = new ArrayList<>();
        for (String value : values) {
            if (temp.contains(value)) {
                throw new IllegalArgumentException(ErrorType.HAS_DUPLICATE.getMessage());
            }
            temp.add(value);
        }
    }

    public static void validateInteger(String value) {
        if (!value.matches("[+-]?\\d+")) {
            throw new IllegalArgumentException(ErrorType.NOT_INTEGER.getMessage());
        }
    }
}
