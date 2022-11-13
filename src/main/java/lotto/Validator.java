package lotto;

import lotto.Exception.ExceptionType;

import java.util.List;

public class Validator {
    public static void validateMoney(String money) {
        validateMoneyType(money);
        validateMoneyValue(Integer.parseInt(money));
    }

    public static void validateMoneyType(String money) {
        try {
            Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionType.MONEY_TYPE_EXCEPTION.getMessage());
        }
    }

    public static void validateMoneyValue(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionType.MONEY_VALUE_EXCEPTION.getMessage());
        }
    }

    public static void validateLottoFormat(List<String> lottos) {
        validateLottoCount(lottos);
        validateLottoType(lottos);
    }

    public static void validateLottoCount(List<String> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_INPUT_COUNT_EXCEPTION.getMessage());
        }
    }

    public static void validateLottoType(List<String> lotto) {
        for (String value : lotto) {
            if (!isInteger(value)) {
                throw new IllegalArgumentException(ExceptionType.MONEY_TYPE_EXCEPTION.getMessage());
            }
        }
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ExceptionType.LOTTO_RANGE_EXCEPTION.getMessage());
            }
        });
    }
}
