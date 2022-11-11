package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Const.COUNT) {
            throw new IllegalArgumentException();
        }
        if (duplicateCheck(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean duplicateCheck(List<Integer> numbers) {
        if (getCount(numbers)) {
            return false;
        }
        return true;
    }

    private boolean getCount(List<Integer> numbers){
        List<Integer> checkNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (checkNumbers.contains(number)) return false;
            checkNumbers.add(number);
        }
        return true;
    }
}
