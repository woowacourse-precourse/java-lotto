package lotto.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.UserLotto;
import lotto.domain.Win;
import lotto.view.OutputView;

public class LottoCalculateService {
    private static final int MATCH_THREE = 3;
    private static final int MATCH_FOUR = 4;
    private static final int MATCH_FIVE = 5;
    private static final int MATCH_SIX = 6;
    private static final int BONUS_ENUM_LABEL = 7;
    private static final int BEFORE_BONUS_INDEX = 6;
    private static final String DECIMAL_FORMAT = "###,##0.0";
    private final OutputView outputView = new OutputView();
    private final Map<Win, Integer> winningCount = new HashMap<>();

    public void calculateWinning(User user, Lotto lotto) {
        countWinning(user, lotto);
        outputView.showEachWinnings(winningCount);
        outputView.showRateOfReturn(getRateOfReturn(user, user.getWinnings()));
    }

    public void countWinning(User user, Lotto lotto) {
        List<UserLotto> userNumbers = user.getAutoNumbers();
        userNumbers
                .forEach(userLotto -> countLottoWinning(user, userLotto.getNumbers(), lotto));
    }

    public String getRateOfReturn(User user, int totalPrice) {
        if (user.getAmount() == 0) {
            return "0.0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return decimalFormat.format((double) totalPrice / user.getAmount() * 100);
    }

    public void countLottoWinning(User user, List<Integer> numbers, Lotto lotto) {
        int countContainsOfLottoWithoutBonus = countUserNumbersContainLotto(numbers, lotto.getNumbers());
        if (isNumberMatchedNormal(countContainsOfLottoWithoutBonus)) {
            winLotto(countContainsOfLottoWithoutBonus, user);
            return;
        }
        if (isNumberMatchedFiveWithBonus(countContainsOfLottoWithoutBonus, numbers, lotto)) {
            winLotto(BONUS_ENUM_LABEL, user);
            return;
        }
        if (isNumberMatchedFive(countContainsOfLottoWithoutBonus, numbers, lotto)) {
            winLotto(countContainsOfLottoWithoutBonus, user);
            return;
        }
    }

    public void winLotto(int value, User user) {
        inputCountOfWinning(Win.FIND.valueOf(value));
        user.addWinnings(Win.FIND.valueOf(value).getPrice());
    }

    public int countUserNumbersContainLotto(List<Integer> userNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int i = 0; i < BEFORE_BONUS_INDEX; i++) {
            if (userNumbers.contains(lottoNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public void inputCountOfWinning(Win winning) {
        winningCount.put(winning, winningCount.getOrDefault(winning, 0) + 1);
    }

    public boolean isNumberMatchedNormal(int countContainsOfLotto) {
        if (countContainsOfLotto == MATCH_THREE || countContainsOfLotto == MATCH_FOUR
                || countContainsOfLotto == MATCH_SIX) {
            return true;
        }
        return false;
    }

    public boolean isNumberMatchedFiveWithBonus(int countContainsOfLotto, List<Integer> numbers, Lotto lotto) {
        if (countContainsOfLotto == MATCH_FIVE && numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public boolean isNumberMatchedFive(int countContainsOfLotto, List<Integer> numbers, Lotto lotto) {
        if (countContainsOfLotto == MATCH_FIVE && !numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }
}