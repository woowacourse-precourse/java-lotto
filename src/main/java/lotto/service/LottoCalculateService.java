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

    public void countEqualsFiveWithBonus() {

    }

    public void countEqualsFive() {

    }

    public void countEqualsFour() {

    }

    public void countEqualsThree() {

    }
}
