package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.domain.info.Rule.END_NUMBER;
import static lotto.domain.info.Rule.START_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicate(List<Integer> numbers) {
        int size = numbers.size();
        int distinctSize = new HashSet<>(numbers).size();
        if (size > distinctSize) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_NUMBER.getNumber() || number > END_NUMBER.getNumber()) {
                System.out.println("[ERROR]");
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
