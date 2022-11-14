package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        isSizeSix(numbers);
        isInCorrectRange(numbers);
        isUnique(numbers);
    }

    private void isSizeSix(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개의 숫자여야 합니다.", LOTTO_SIZE));
        }
    }

    private void isInCorrectRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
                throw new IllegalArgumentException(
                        String.format("[ERROR] 로또 번호는 %d부터 %d사이의 숫자여야 합니다.", MIN_NUMBER_RANGE, MAX_NUMBER_RANGE));
            }
        }
    }

    private void isUnique(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>();
        numbersSet.addAll(numbers);
        if (numbersSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 모두 서로 다른 숫자여야 합니다.");
        }
    }
}
