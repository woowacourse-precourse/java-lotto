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

    public Rank compare(Lotto WinningLotto) {
        return null;
    }

    private int countMatchingNumber() {
        return 0;
    }

    private boolean matchBonusNumber() {
        return true;
    }

    private Rank getRank(int matchingCount, boolean matchBonus) {
        return null;
    }
}
