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
    private static final int PRICE_OF_SIXTH = 2000000000;
    private static final int PRICE_OF_FIFTH_WITH_BONUS = 30000000;
    private static final int PRICE_OF_FIFTH = 1500000;
    private static final int PRICE_OF_FOURTH = 50000;
    private static final int PRICE_OF_THIRD = 5000;
    private static final OutputView outputView = new OutputView();
    private Map<Winning, Integer> countOfWinning = new HashMap<>();

    public void calculateWinning(User user, Lotto lotto) {
        countLottoWinningCount(user, lotto);
        outputView.responseWinningHistory(countOfWinning);
        outputView.responseYieldOfLotto(getYieldOfLotto(user, user.getWinningPrice()));
    }

    public double getYieldOfLotto(User user, int totalPrice) {
        double yield = ((double) totalPrice / user.getBuyingPrice() * 100.0);
        return yield;
    }

    public void countLottoWinningCount(User user, Lotto lotto) {
        List<UserLotto> userLottos = user.getLottos();
        for (UserLotto userLotto : userLottos) {
            List<Integer> userLottoNumbers = userLotto.getNumbers();
            countEqualsSix(user, userLottoNumbers, lotto);
            countEqualsFive(user, userLottoNumbers, lotto);
            countEqualsFour(user, userLottoNumbers, lotto);
            countEqualsThird(user, userLottoNumbers, lotto);
        }
    }

    public void countEqualsSix(User user, List<Integer> numbers, Lotto lotto) {
        if (numbers.equals(lotto.getNumbers())) {
            inputWinningLotto(Winning.SIXTH);
            user.addWinningPrice(PRICE_OF_SIXTH);
        }
    }

    public void countEqualsFive(User user, List<Integer> numbers, Lotto lotto) {
        if (countUserNumbersContainLotto(numbers, lotto.getNumbers()) == 5 && numbers.contains(lotto.getBonusNumber())) {
            inputWinningLotto(Winning.FIFTH_WITH_BONUS);
            user.addWinningPrice(PRICE_OF_FIFTH_WITH_BONUS);
            return;
        }

        if (countUserNumbersContainLotto(numbers, lotto.getNumbers()) == 5) {
            inputWinningLotto(Winning.FIFTH);
            user.addWinningPrice(PRICE_OF_FIFTH);
        }
    }

    public void countEqualsFour(User user, List<Integer> numbers, Lotto lotto) {
        if (countUserNumbersContainLotto(numbers, lotto.getNumbers()) == 4) {
            inputWinningLotto(Winning.FOURTH);
            user.addWinningPrice(PRICE_OF_FOURTH);
        }
    }

    public void countEqualsThird(User user, List<Integer> numbers, Lotto lotto) {
        if (countUserNumbersContainLotto(numbers, lotto.getNumbers()) == 3) {
            inputWinningLotto(Winning.THIRD);
            user.addWinningPrice(PRICE_OF_THIRD);
        }
    }

    public int countUserNumbersContainLotto(List<Integer> userNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void inputWinningLotto(Winning winning) {
        countOfWinning.put(winning, countOfWinning.getOrDefault(winning, 0) + 1);
    }
}
