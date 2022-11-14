package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException();
        }
        if (isDuplicated(numbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.SIZE.getValue()) {
            return false;
        }
        return true;
    }

    private boolean isValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstant.STARTFROM.getValue()
                    || number > LottoConstant.ENDTO.getValue()) return false;
        }
        return true;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) return true;
        return false;
    }

}
