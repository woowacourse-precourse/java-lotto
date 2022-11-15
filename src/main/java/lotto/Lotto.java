package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Judge.validateRange(numbers);
        checkRedundancy(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 숫자여야 합니다.");
        }
    }

    private void checkRedundancy(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public int confirmNumbers(List<Integer> winningNumbers) {
        int sameNumberCount = 0;
        int bonusNumber = 0;

        for (Integer number : this.numbers) {
            if (winningNumbers.contains(number)) {
                sameNumberCount++;
            }
        }

        if (numbers.contains(winningNumbers.get(6))) {
            bonusNumber = 1;
        }

        return defineRank(sameNumberCount, bonusNumber);
    }

    private int defineRank(int sameNumberCount, int bonusNumber) {
        if (sameNumberCount == 6) {
            return 7 - sameNumberCount + bonusNumber;
        }
        return 8 - sameNumberCount;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
