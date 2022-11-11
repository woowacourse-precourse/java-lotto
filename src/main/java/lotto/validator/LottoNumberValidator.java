package lotto.validator;

import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class LottoNumberValidator {

    public static void validateExistDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_EXIST_DUPLICATE_NUMBER_IN_LOTTO.message());
        }
    }
}
