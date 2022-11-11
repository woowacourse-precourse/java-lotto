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

    public void countEqualsSix(List<Integer> numbers, List<Integer> lottoNumbers) {
        if (numbers.equals(lottoNumbers)) {
            countOfWinning.put(Winning.SIXTH, countOfWinning.getOrDefault(Winning.SIXTH, 0) + 1);
        }
    }

    public void countEqualsFiveWithBonus(List<Integer> numbers, List<Integer> lottoNumbers) {

    }

    public void countEqualsFive() {

    }

    public void countEqualsFour() {

    }

    public void countEqualsThree() {

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
