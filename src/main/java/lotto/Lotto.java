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

    private int matchWinningNumber(List<Integer> winningNumbers) {
        int matchNumbers = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (winningNumbers.contains(numbers.get(i))) {
                matchNumbers++;
            }
        }
        return matchNumbers;
    }

    public Rank matchRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchNumber = matchWinningNumber(winningNumbers);
        Rank lottoRank = findRank(matchNumber, bonusNumber);
        return lottoRank;
    }

    private Rank findRank(int matchNumber, int bonusNumber) {
        if (Rank.FIRST.getMatchNumber() == matchNumber) {
            return Rank.FIRST;
        }
        if (Rank.SECOND.getMatchNumber() == matchNumber && matchBonusNumber(bonusNumber)) {
            return Rank.SECOND;
        }
        if (Rank.THIRD.getMatchNumber() == matchNumber) {
            return Rank.THIRD;
        }
        if (Rank.FOURTH.getMatchNumber() == matchNumber) {
            return Rank.FOURTH;
        }
        if (Rank.FIFTH.getMatchNumber() == matchNumber) {
            return Rank.FIFTH;
        }
        return Rank.NOTHING;
    }

    private boolean matchBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)){
            return true;
        }
        return false;
    }
}
