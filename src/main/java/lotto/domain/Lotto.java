package lotto.domain;

import lotto.ui.Error;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.MUST_BE_SIX_DIGIT);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Error.HAD_DUPLICATE_NUMBER);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(Error.MUST_BE_NUMBERS_BETWEEN_1_TO_45);
            }
        }
    }

    private List<Integer> sort(List<Integer> unsortedNumbers){
        List<Integer> numbers = new ArrayList<>(unsortedNumbers);
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
