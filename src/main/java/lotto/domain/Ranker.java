package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranker {
    private List<Integer> winningNumber;
    private int bonusNumber;

    Ranker(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningResult, Integer> rankTotal(List<Lotto> lottos) {
        return null;
    }

    public WinningResult rank(Lotto lotto) {
        NumberMatcher matcher = new NumberMatcher();
        List<Integer> numbers = lotto.getNumbers();
        int count = matcher.winningNumberCount(numbers, winningNumber);
        return WinningResult.match(count, numbers.contains(bonusNumber));
    }
}
