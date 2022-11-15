package lotto.participant;

import lotto.domain.Lotto;
import lotto.constant.Rank;
import lotto.domain.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatcher {

    private Map<Rank, Integer> rankCounts;

    public Map<Rank, Integer> matchAllLottos(List<Lotto> publishedLottos, WinningLotto winningLotto) {
        rankCounts = new HashMap<>();
        publishedLottos.forEach(publishedLotto -> matchLotto(publishedLotto, winningLotto));
        return rankCounts;
    }

    private void matchLotto(Lotto lotto, WinningLotto winningLotto) {
        int countOfMatchedNumbers = countWinningLottoNumbers(lotto.getNumbers(), winningLotto);
        boolean bonusNumberIsMatched = checkIfBonusNumberMatch(lotto.getNumbers(), winningLotto);
        saveResult(countOfMatchedNumbers, bonusNumberIsMatched);
    }

    private int countWinningLottoNumbers(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        int countOfMatchedNumbers = 0;
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();
        for (Integer winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                ++countOfMatchedNumbers;
            }
        }
        return countOfMatchedNumbers;
    }

    private boolean checkIfBonusNumberMatch(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        return lottoNumbers.contains(winningLotto.getBonusNumber());
    }

    private void saveResult(int numberOfMatchedLottoNumber, boolean bonus) {
        Rank rank = null;
        if (numberOfMatchedLottoNumber == 6) {
            rank = Rank.FIRST_SIX_MATCHED;
        } else if (numberOfMatchedLottoNumber == 5 && bonus) {
            rank = Rank.SECOND_FIVE_WITH_BONUS;
        } else if (numberOfMatchedLottoNumber == 5) {
            rank = Rank.THIRD_FIVE_MATCHED;
        } else if (numberOfMatchedLottoNumber == 4) {
            rank = Rank.FOURTH_FOUR_MATCHED;
        } else if (numberOfMatchedLottoNumber == 3) {
            rank = Rank.FIFTH_THREE_MATCHED;
        }
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }
}
