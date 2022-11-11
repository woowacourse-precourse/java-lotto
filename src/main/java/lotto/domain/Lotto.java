package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    private void isInCorrectRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void isUnique(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>();
        numbersSet.addAll(numbers);
        if (numbersSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 모두 서로 다른 숫자여야 합니다.");
        }
    }
}
