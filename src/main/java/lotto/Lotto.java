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
    public int confirmNumbers(List<Integer> numbers) {
        int sameNumberCount = 0;
        int bonusNumber = 0;

        for (Integer number : this.numbers) {
            if (numbers.contains(number)) {
                sameNumberCount++;
            }
        }

        if (this.numbers.contains(numbers.get(6))) {
            bonusNumber = 1;
        }

        return defineRank(sameNumberCount, bonusNumber);
    }

    private int defineRank(int sameNumberCount, int bonusNumber) {
        if (sameNumberCount == 6) {
            return 7 - sameNumberCount + bonusNumber;
        }
        return 7 - sameNumberCount;
    }
}
