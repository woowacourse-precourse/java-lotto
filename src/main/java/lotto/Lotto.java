package lotto;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        String returnedString = "[" + String.valueOf(numbers.get(0));
        for (int idx = 1; idx < numbers.size(); idx++) {
            returnedString += ", " + numbers.get(idx);
        }
        return returnedString + "]";
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateLottoNumbersUniqueness(numbers);
    }

    private void validateLottoNumbersUniqueness(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            set.add(number);
        }
        if (set.size() < numbers.size()) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_DUPLICATE.message);
        }
    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_SIZE.message);
        }
    }
}
