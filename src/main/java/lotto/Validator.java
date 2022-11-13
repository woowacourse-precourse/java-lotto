package lotto;

import lotto.Exception.ExceptionType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static void validateLotto(String input) {
        List<String> lotto = List.of(input.split(","));
        validateLottoFormat(lotto);
        List<Integer> lottoNumbers = convertStringListToIntegerList(lotto);
        validateRange(lottoNumbers);
        validateDuplicates(lottoNumbers);
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

    public static List<Integer> convertStringListToIntegerList(List<String> lotto) {
        return lotto.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ExceptionType.LOTTO_RANGE_EXCEPTION.getMessage());
            }
        });
    }

    public static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> duplicateCheckSet = new HashSet<>();
        for (Integer number : numbers) {
            if (duplicateCheckSet.contains(number)) {
                throw new IllegalArgumentException(ExceptionType.LOTTO_DUPLICATE_EXCEPTION.getMessage());
            }
            duplicateCheckSet.add(number);
        }
    }

    public static void validateBonusNumber(List<Integer> lotto, String bonusNumber) {
        validateBonusType(bonusNumber);
        validateBonusDuplicate(lotto, bonusNumber);
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
