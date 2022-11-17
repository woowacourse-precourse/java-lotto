package lotto.domain;

import lotto.domain.constant.ConstantValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        try {
            isSixNumbers(numbers);
            isAllDifferentNumbers(numbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }

    private void isSixNumbers(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != ConstantValue.SIX) {
            throw new IllegalArgumentException();
        }
    }

    private void isAllDifferentNumbers(List<Integer> numbers) throws IllegalArgumentException {
        List<Integer> container = new ArrayList<>();

        for (Integer number : numbers) {
            if (container.contains(number)) {
                throw new IllegalArgumentException();
            }
            container.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public void sortNumbers() {
        Collections.sort(this.numbers);
    }
}
