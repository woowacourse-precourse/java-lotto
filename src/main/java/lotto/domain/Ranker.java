package lotto.domain;

import java.util.List;

public class Ranker {
    private List<Integer> winningNumber;
    private int bonusNumber;

    Ranker(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult rank(Lotto lotto) {
        NumberMatcher matcher = new NumberMatcher();
        List<Integer> numbers = lotto.getNumbers();
        int count = matcher.winningNumberCount(numbers, winningNumber);
        return WinningResult.match(count, numbers.contains(bonusNumber));
    }
}
