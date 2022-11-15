package lotto.validation;

import static lotto.message.ErrorMessage.DUPLICATE;
import static lotto.message.ErrorMessage.OUT_OF_RANGE;
import static lotto.value.LottoValue.LOTTO_END_NUMBER;
import static lotto.value.LottoValue.LOTTO_START_NUMBER;

import java.util.List;

public class LottoNumberValidation {

    static public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력한 숫자들의 개수가 6개가 아닙니다.");
        }
    }

    static public void validateDuplicate(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (!isOnceAppear(numbers, number)) {
                throw new IllegalArgumentException(DUPLICATE.getMessage());
            }
        });
    }

    static public void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(LottoNumberValidation::validateNumberRange);
    }

    static public void validateNumberRange(int number) {
        if (!isRanged(number)) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE.getMessage());
        }
    }

    static public boolean isOnceAppear(List<Integer> numbers, int number) {
        return numbers.indexOf(number) == numbers.lastIndexOf(number);
    }

    private static boolean isRanged(int number) {
        return LOTTO_START_NUMBER.getValue() <= number && number <= LOTTO_END_NUMBER.getValue();
    }
}
