package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isWrongSize(numbers)) {
            createError(LottoError.WRONG_SIZE);
        }
        if (isDuplicate(numbers)) {
            createError(LottoError.DUPLICATION);
        }
        if (isOutOfBound(numbers)) {
            createError(LottoError.OUT_OF_BOUND);
        }
    }
    private boolean isWrongSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }
    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbers.size() != numbersSet.size();
    }
    private boolean isOutOfBound(List<Integer> numbers) {
        boolean hasWrongBoundaryNumber = false;
        for (int number : numbers) {
            hasWrongBoundaryNumber |= number < LottoState.START.number();
            hasWrongBoundaryNumber |= number > LottoState.END.number();
        }
        return hasWrongBoundaryNumber;
    }
    private void createError(LottoError error) {
        error.printMessage();
        throw new IllegalArgumentException();
    }
}
