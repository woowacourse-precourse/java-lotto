package lotto.Model;

import lotto.resources.Constants;

import java.util.List;
import java.util.HashSet;

import java.util.function.Consumer;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
        HashSet<Integer> numSet = new HashSet<>(numbers);
        if (!(numSet.size() == Constants.LOTTO_LENGTH.getValue() ||
                numSet.size() == Constants.BONUS_LOTTO_SIZE.getValue())) {
            throw new IllegalArgumentException();
        }
    }

    public void indexedForEach(Consumer<Integer> consumer) {
        for (Integer number : numbers) {
            consumer.accept(number);
        }
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
