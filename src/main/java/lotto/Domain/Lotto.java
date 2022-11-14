package lotto.Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        sizeValidate(numbers);
        duplicationValidate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicationValidate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i != numbers.indexOf(i)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for (int indexNumber : numbers) {
            if (indexNumber < START_NUMBER || indexNumber > END_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }
}
