package lotto.domain.validation;

import java.util.HashSet;
import java.util.List;
import lotto.domain.LottoEnum;
import lotto.view.validation.ExceptionMessage;

public class LottoNumbersValidation {

    public static void validate(List<Integer> LottoNumbers) {
        validateNumbersLength(LottoNumbers);
        validateNumberRange(LottoNumbers);
        validateNoDuplicateNumbers(LottoNumbers);
    }

    private static void validateNumberRange(List<Integer> userNumbers) {
        boolean correctNumber = userNumbers.stream().allMatch(LottoEnum::isNumberInRange);
        if (!correctNumber) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE.toString());
        }
    }

    private static void validateNoDuplicateNumbers(List<Integer> userNumbers) {
        HashSet<Integer> numberAppeared = new HashSet<>();
        for (Integer number : userNumbers) {
            checkDuplicateNumber(number, numberAppeared);
        }
    }

    private static void validateNumbersLength(List<Integer> userNumbers) {
        if (userNumbers.size() != LottoEnum.LENGTH.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBERS_LENGTH.toString());
        }
    }

    private static void checkDuplicateNumber(Integer number, HashSet<Integer> numberAppeared) {
        if (numberAppeared.contains(number)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER.toString());
        }
        numberAppeared.add(number);
    }
}
