package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateIsDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateIsDuplicated(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static Prize calculate(List<Integer> lotto, List<Integer> targetNumbers, int bonusNumber) {
        int result = 0;
        boolean isBonusRight = false;
        for (int i : targetNumbers) {
            if (lotto.contains(i)) {
                result++;
            }
        }
        if (result == 5) {
            if (lotto.contains(bonusNumber)) {
                isBonusRight = true;
            }
        }

        return Prize.getPrize(result, isBonusRight);
    }
}
