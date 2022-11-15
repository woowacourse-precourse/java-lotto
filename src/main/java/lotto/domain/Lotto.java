package lotto.domain;

import lotto.util.ValidUtil;

import java.util.Collections;
import java.util.List;

import static lotto.constants.ErrorCode.INVALID_NUMBER_OF_DIGITS;
import static lotto.constants.ErrorCode.INVALID_NUMERIC_CONFIGURATION;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberUnit(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }
    public void validateNumberUnit(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_DIGITS);
        }
    }
    public void validateDuplication(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> subList = numbers.subList(i + 1, numbers.size());
            if (subList.contains(numbers.get(i))) {
                throw new IllegalArgumentException(INVALID_NUMERIC_CONFIGURATION);
            }
        }
    }
    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < numbers.size()-1; i++) {
            builder.append(numbers.get(i) + ", ");
        }
        builder.append(numbers.get(numbers.size() - 1) + "]");

        return builder.toString();
    }

    public int compareLotto(Lotto lotto) {
        return (int) this.numbers.stream().
                filter(lotto.numbers::contains).count();
    }

    public boolean containBonus(int number) {
        return this.numbers.contains(number);
    }

}
