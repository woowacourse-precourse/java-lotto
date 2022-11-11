package lotto.domain;

import lotto.domain.enums.Message;
import lotto.domain.enums.Number;
import lotto.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            isSixNumbers(numbers);
            isAllDifferentNumbers(numbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw InputUtil.makeIllegalArgumentException(Message.NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void isSixNumbers(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != Number.SIX.getValue()) {
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
}
