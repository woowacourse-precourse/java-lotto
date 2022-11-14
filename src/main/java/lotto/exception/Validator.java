package lotto.exception;

import lotto.domain.Lotto;
import lotto.util.TypeConverter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateMoneyString(String money) {
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

    public static void validateLottoString(String input) {
        List<String> lotto = List.of(input.split(","));
        validateLottoFormat(lotto);
        List<Integer> lottoNumbers = TypeConverter.convertStringListToIntegerList(lotto);
        validateLottoNumberRange(lottoNumbers);
        validateLottoNumberDuplicates(lottoNumbers);
    }

    public static void validateLottoFormat(List<String> lottos) {
        validateLottoType(lottos);
        validateLottoCount(lottos);
    }

    public static void validateLottoCount(List<String> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_INPUT_FORMAT_EXCEPTION.getMessage());
        }
    }

    public static void validateLottoType(List<String> lotto) {
        for (String value : lotto) {
            if (!isInteger(value)) {
                throw new IllegalArgumentException(ExceptionType.LOTTO_INPUT_FORMAT_EXCEPTION.getMessage());
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

    public static void validateLottoNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ExceptionType.LOTTO_RANGE_EXCEPTION.getMessage());
            }
        });
    }

    public static void validateLottoNumberDuplicates(List<Integer> numbers) {
        Set<Integer> duplicateCheckSet = new HashSet<>();
        for (Integer number : numbers) {
            if (duplicateCheckSet.contains(number)) {
                throw new IllegalArgumentException(ExceptionType.LOTTO_DUPLICATE_EXCEPTION.getMessage());
            }
            duplicateCheckSet.add(number);
        }
    }

    public static void validateBonusNumber(Lotto lotto, String bonusNumber) {
        validateBonusType(bonusNumber);
        validateBonusDuplicate(lotto.getNumbers(), bonusNumber);
    }

    private static void validateBonusDuplicate(List<Integer> lotto, String bonusNumber) {
        if (lotto.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ExceptionType.BONUS_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    public static void validateBonusType(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionType.BONUS_INPUT_TYPE_EXCEPTION.getMessage());
        }
    }
}
