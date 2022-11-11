package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.view.OutputView;

public class LottoCalculateService {
    private final OutputView outputView = new OutputView();
    private int winningPrice = 0;
    private Map<Winning, Integer> countOfWinning = new HashMap<>();

    public void calculateWinning(User user, Lotto lotto) {

    }

    public void countEqualsSix(List<Integer> numbers, Lotto lotto) {
        if (numbers.equals(lotto.getNumbers())) {
            countOfWinning.put(Winning.SIXTH, countOfWinning.getOrDefault(Winning.SIXTH, 0) + 1);
        }
    }

    public void countEqualsFiveWithBonus(List<Integer> numbers, Lotto lotto) {
        if (containsNumCount(numbers, lotto.getNumbers()) == 5 && numbers.contains(lotto.getBonusNumber())) {
            countOfWinning.put(Winning.FIFTH_WITH_BONUS, countOfWinning.getOrDefault(Winning.FIFTH_WITH_BONUS, 0) + 1);
        }
    }

    public void countEqualsFive(List<Integer> numbers, Lotto lotto) {
        if (containsNumCount(numbers, lotto.getNumbers()) == 5) {
            countOfWinning.put(Winning.FIFTH, countOfWinning.getOrDefault(Winning.FIFTH_WITH_BONUS, 0) + 1);
        }
    }

    public void countEqualsFour(List<Integer> numbers, Lotto lotto) {
        if (containsNumCount(numbers, lotto.getNumbers()) == 4) {
            countOfWinning.put(Winning.FOURTH, countOfWinning.getOrDefault(Winning.FIFTH_WITH_BONUS, 0) + 1);
        }
    }

    public void countEqualsThird(List<Integer> numbers, Lotto lotto) {
        if (containsNumCount(numbers, lotto.getNumbers()) == 3) {
            countOfWinning.put(Winning.THIRD, countOfWinning.getOrDefault(Winning.FIFTH_WITH_BONUS, 0) + 1);
        }
    }

    public int containsNumCount(List<Integer> userNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
