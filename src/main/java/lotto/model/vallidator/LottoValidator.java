package lotto.model.vallidator;

import java.util.List;
import lotto.model.Constants;
import lotto.model.Lotto;

public class LottoValidator {
    public static void validate(List<Integer> numbers){
        isValidLength(numbers);
        isInRange(numbers);
        isUnique(numbers);
    }

    public static void validate(Lotto lotto, int number){
        isInRange(number);
        isUnique(lotto, number);
    }

    private static void isValidLength(List<Integer> numbers) {
        if (numbers.size() != Constants.NUMBER_LENGTH) {
            throw new IllegalArgumentException(LottoError.LENGTH.message());
        }
    }

    private static void isUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Constants.NUMBER_LENGTH) {
            throw new IllegalArgumentException(LottoError.UNIQUE.message());
        }
    }

    private static void isInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Constants.NUMBER_RANGE_START || number > Constants.NUMBER_RANGE_END) {
                throw new IllegalArgumentException(LottoError.RANGE.message());
            }
        }
    }

    private static void isInRange(int number) {
        if (number < Constants.NUMBER_RANGE_START || number > Constants.NUMBER_RANGE_END) {
            throw new IllegalArgumentException(LottoError.RANGE.message());
        }
    }

    private static void isUnique(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoError.UNIQUE.message());
        }
    }
}
