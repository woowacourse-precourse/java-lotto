package lotto.validator;

import lotto.exception.ExceptionType;
import lotto.util.TypeConverter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    public static void validate(String input) {
        List<String> lotto = List.of(input.split(","));
        validateFormat(lotto);
        List<Integer> lottoNumbers = TypeConverter.convertStringListToIntegerList(lotto);
        validateRange(lottoNumbers);
        validateDuplicates(lottoNumbers);
    }

    public static void validateFormat(List<String> lottos) {
        validateType(lottos);
        validateCount(lottos);
    }

    public static void validateCount(List<String> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_INPUT_FORMAT_EXCEPTION.getMessage());
        }
    }

    public static void validateType(List<String> lotto) {
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
}
