package lotto.domain;

import static lotto.constant.ErrorMessage.LOTTO_ELEMENTS_DUPLICATE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_ELEMENTS_RANGE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_ELEMENTS_SIZE_ERROR;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

    }

    private void checkListSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_ELEMENTS_SIZE_ERROR);
        }
    }

    private void checkListRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException(LOTTO_ELEMENTS_RANGE_ERROR);
            }
        }
    }

    public void printNumbers() {
        System.out.println(this.numbers.toString());
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }

}
