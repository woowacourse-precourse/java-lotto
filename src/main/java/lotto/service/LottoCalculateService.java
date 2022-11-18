package lotto.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.UserLotto;
import lotto.domain.Winning;
import lotto.view.OutputView;

public class LottoCalculateService {
    private static final int THREE_NUMBER_MATCHES = 3;
    private static final int FOUR_NUMBER_MATCHES = 4;
    private static final int FIVE_NUMBER_MATCHES = 5;
    private static final int SIX_NUMBER_MATCHES = 6;
    private static final int BONUS_ENUM_LABEL = 7;
    private static final int BEFORE_BONUS_NUMBER_INDEX = 6;
    private static final String DECIMAL_FORMAT = "###,##0.0";
    private final OutputView outputView = new OutputView();
    private Map<Winning, Integer> countOfWinning = new HashMap<>();

    public void calculateWinning(User user, Lotto lotto) {
        countLottoWinningCount(user, lotto);
        outputView.responseWinningHistory(countOfWinning);
        outputView.responseYieldOfLotto(getYieldOfLotto(user, user.getWinningPrice()));
    }

    public void countLottoWinningCount(User user, Lotto lotto) {
        List<UserLotto> userLottos = user.getLottos();
        userLottos
                .stream()
                .forEach(userLotto -> countLottoWinning(user, userLotto.getNumbers(), lotto));
    }

    public String getYieldOfLotto(User user, int totalPrice) {
        if (user.getBuyingPrice() == 0) {
            return "0.0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return decimalFormat.format((double) totalPrice / user.getBuyingPrice() * 100);
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
        inputCountOfWinning(Winning.FIND.valueOf(value));
        user.addWinningPrice(Winning.FIND.valueOf(value).getPrice());
    }

    public int countUserNumbersContainLotto(List<Integer> userNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int i = 0; i < BEFORE_BONUS_NUMBER_INDEX; i++) {
            if (userNumbers.contains(lottoNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public void inputCountOfWinning(Winning winning) {
        countOfWinning.put(winning, countOfWinning.getOrDefault(winning, 0) + 1);
    }

    public boolean isNumberMatchedNormal(int countContainsOfLotto) {
        if (countContainsOfLotto == THREE_NUMBER_MATCHES || countContainsOfLotto == FOUR_NUMBER_MATCHES
                || countContainsOfLotto == SIX_NUMBER_MATCHES) {
            return true;
        }
        return false;
    }

    public boolean isNumberMatchedFiveWithBonus(int countContainsOfLotto, List<Integer> numbers, Lotto lotto) {
        if (countContainsOfLotto == FIVE_NUMBER_MATCHES && numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public boolean isNumberMatchedFive(int countContainsOfLotto, List<Integer> numbers, Lotto lotto) {
        if (countContainsOfLotto == FIVE_NUMBER_MATCHES && !numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }
}
