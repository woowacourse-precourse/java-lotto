package lotto;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.ExceptionConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE.getValue());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(LOTTO_RANGE.getValue());
            }
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            Set<Integer> check = new HashSet<>(numbers);
            if (check.size() != numbers.size()) {
                throw new IllegalArgumentException(LOTTO_DUPLICATED.getValue());
            }
        }
    }

    public void validateBonus(int bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_BONUS_DUPLICATED.getValue());
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(LOTTO_BONUS_RANGE.getValue());
        }
    }

}
