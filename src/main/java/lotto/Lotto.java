package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    static final int LOTTO_SIZE = 6;
    static final int PRICE_OF_LOTTO = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (checkSize(numbers) || checkOverlap(numbers) || checkOutOfRange(numbers)) {
            throw new IllegalArgumentException(ErrorType.MAKE_LOTTO_ERROR.getMessage());
        }
    }

    private boolean checkSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;

    }

    private boolean checkOverlap(List<Integer> numbers) {
        Set<Integer> removeOverlap = new HashSet<>(numbers);
        return numbers.size() != removeOverlap.size();
    }

    private boolean checkOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > MAX_NUMBER || number < MIN_NUMBER) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

}
