package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * 당첨 번호와 보너스 번호 확인 클래스
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isInCorrectRange(numbers);
        isNotDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers, int bonusNum) {
        isNotContainBonusNum(numbers, bonusNum);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isInCorrectRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (0 >= number || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void isNotDuplication(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void isNotContainBonusNum(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
