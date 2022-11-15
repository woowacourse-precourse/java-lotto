package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final String WRONG_SIZE_MESSAGE = "[ERROR]: It's not a size 6.";
    private static final String DUPLICATE_INPUT_MESSAGE = "[ERROR]: There are duplicate numbers.";

    protected static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(WRONG_SIZE_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>(numbers);
        if (numbers.size() != temp.size()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_MESSAGE);
        }
    }

    public int computeMatchCount(Lotto lottoNumbers) {
        return lottoNumbers.compareLottoNumbers(numbers);
    }

    private int compareLottoNumbers(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}