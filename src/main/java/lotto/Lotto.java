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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank compare(List<Integer> winningNumbers, int bonusNumber) {
        boolean matchBonus = matchBonusNumber(bonusNumber)

        int numberOfMatch = countMatchingNumber(winningNumbers);
        if(matchBonus) {
            numberOfMatch++;
        }

        Rank rank = getRank(numberOfMatch, matchBonus);
        return rank;
    }

    private int countMatchingNumber(List<Integer> winningNumbers) {
        return 0;
    }

    private boolean matchBonusNumber(int bonusNumber) {
        return true;
    }

    private Rank getRank(int matchingCount, boolean matchBonus) {
        return null;
    }
}
