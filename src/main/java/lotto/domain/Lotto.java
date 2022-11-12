package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSizeValid(numbers)) {
            throw new IllegalArgumentException("[ERROR] 생성된 숫자의 갯수가 일치하지 않습니다. ");
        }
        if (!isRangeValid(numbers)) {
            throw new IllegalArgumentException("[ERROR] 생성된 숫자가 1보다 작거나 45보다 큽니다. ");
        }
        if (!noOverlap(numbers)) {
            throw new IllegalArgumentException("[ERROR] 생성된 숫자 중 중복된 숫자가 있습니다. ");
        }
    }

    // TODO: 추가 기능 구현
    private boolean isSizeValid(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isRangeValid(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    private boolean noOverlap(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) != 1) {
                return false;
            }
        }
        return true;
    }

}
