package lotto.validation;

import static lotto.message.ErrorMessage.OUT_OF_RANGE_MESSAGE;
import static lotto.value.LottoValues.LOTTO_END_NUMBER;
import static lotto.value.LottoValues.LOTTO_START_NUMBER;

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
                throw new IllegalArgumentException("[ERROR] 중복이 되는 숫자가 존재합니다.");
            }
        });
    }

    static public void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(LottoNumberValidation::validateNumberRange);
    }

    static public void validateNumberRange(int number) {
        if (!isRanged(number)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE.toString());
        }
    }

    static public boolean isOnceAppear(List<Integer> numbers, int number) {
        return numbers.indexOf(number) == numbers.lastIndexOf(number);
    }


    private static boolean isRanged(int number) {
        return LOTTO_START_NUMBER.getValue() <= number && number <= LOTTO_END_NUMBER.getValue();
    }
}
