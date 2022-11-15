package lotto.domain;

import lotto.exception.Check;
import lotto.exception.CustomException;

import java.util.List;

public class PlusLotto {
    private final int plusNumber;

    public PlusLotto(int plusNumber) {
        this.plusNumber = plusNumber;
    }

    private void duplicate(List<Integer> numbers, int plusNumber) {
        Check check = new Check();
        if (!check.checkDuplicate(numbers, plusNumber)) {
            throw new IllegalArgumentException(CustomException.DUPLICATE.getMessage());
        }
    }

    private void range(int plusNumber) {
        Check check = new Check();
        if (!check.checkRange(plusNumber)) {
            throw new IllegalArgumentException(CustomException.RANGE.getMessage());
        }
    }

    public int getPlusNumber() {
        return plusNumber;
    }
}
