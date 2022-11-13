package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
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
}
