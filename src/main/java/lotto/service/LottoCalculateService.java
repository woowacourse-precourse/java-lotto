package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.UserLotto;
import lotto.domain.Winning;
import lotto.view.OutputView;

public class LottoCalculateService {
    private int winningPrice = 0;
    private final OutputView outputView = new OutputView();
    private Map<Winning, Integer> countOfWinning = new HashMap<>();

    public Map<Winning, Integer> calculateWinning(User user, Lotto lotto) {
        countLottoWinningCount(user, lotto);
        outputView.responseWinningHistory(countOfWinning);
        return countOfWinning;
    }

    public void countLottoWinningCount(User user, Lotto lotto) {
        List<UserLotto> userLottos = user.getLottos();
        for (UserLotto userLotto : userLottos) {
            List<Integer> userLottoNumbers = userLotto.getNumbers();
            countEqualsSix(userLottoNumbers, lotto);
            countEqualsFive(userLottoNumbers, lotto);
            countEqualsFour(userLottoNumbers, lotto);
            countEqualsThird(userLottoNumbers, lotto);
        }
    }

    public void countEqualsSix(List<Integer> numbers, Lotto lotto) {
        if (numbers.equals(lotto.getNumbers())) {
            inputWinning(Winning.SIXTH);
        }
    }

    public void countEqualsFive(List<Integer> numbers, Lotto lotto) {
        if (containsNumCount(numbers, lotto.getNumbers()) == 5 && numbers.contains(lotto.getBonusNumber())) {
            inputWinning(Winning.FIFTH_WITH_BONUS);
            return;
        }
        inputWinning(Winning.FIFTH);
    }

    public void countEqualsFour(List<Integer> numbers, Lotto lotto) {
        if (containsNumCount(numbers, lotto.getNumbers()) == 4) {
            inputWinning(Winning.FOURTH);
        }
    }

    public void countEqualsThird(List<Integer> numbers, Lotto lotto) {
        if (containsNumCount(numbers, lotto.getNumbers()) == 3) {
            inputWinning(Winning.THIRD);
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

    public void inputWinning(Winning winning) {
        countOfWinning.put(winning, countOfWinning.getOrDefault(winning, 0) + 1);
    }
}
