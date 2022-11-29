package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranker {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public Ranker(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningResult, Integer> rankTotal(List<Lotto> lottos) {
        Map<WinningResult, Integer> rankResults = new HashMap<>();
        for (Lotto lotto : lottos) {
            WinningResult result = rank(lotto);
            int count = rankResults.getOrDefault(result, 0) + 1;
            rankResults.put(result, count);
        }
        return rankResults;
    }

    public WinningResult rank(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int count = winningNumberCount(numbers, winningNumber);
        return WinningResult.match(count, numbers.contains(bonusNumber));
    }

    private int winningNumberCount(List<Integer> buyer, List<Integer> winningNumber) {
        int count = 0;
        for (Integer number: buyer) {
            if(winningNumber.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
