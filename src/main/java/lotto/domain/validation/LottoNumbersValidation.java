package lotto.domain.validation;

import java.util.HashSet;
import java.util.List;
import lotto.domain.LottoEnum;
import lotto.user.UserUtil;
import lotto.user.validation.ExceptionMessage;

public class LottoNumbersValidation {
    private static final String INPUT_NUMBERS_REGEXP = "^([1-9]+,)+[1-9]+$";

    public static void validateInputLottoNumbers(String userInput) {
        validateInputFormat(userInput);
    }

    public static void validateLottoNumbers(List<Integer> LottoNumbers) {
        validateNumbersLength(LottoNumbers);
        validateNumberRange(LottoNumbers);
        validateNoDuplicateNumbers(LottoNumbers);
    }

    private static void validateInputFormat(String uerInput) {
        if (!uerInput.matches(INPUT_NUMBERS_REGEXP)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_FORMAT.toString());
        }
    }

    private static void validateNumberRange(List<Integer> userNumbers) {
        boolean correctNumber = userNumbers.stream().allMatch(LottoEnum::isNumberInRange);
        if (!correctNumber) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE.toString());
        }
    }

    public static void validateNoDuplicateNumbers(List<Integer> userNumbers) {
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
