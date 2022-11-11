package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isWrongSize(numbers)) {
            LottoError.WRONG_SIZE.createError();
        }
        if (isDuplicate(numbers)) {
            LottoError.DUPLICATION.createError();
        }
        if (isOutOfBound(numbers)) {
            LottoError.OUT_OF_BOUND.createError();
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
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
