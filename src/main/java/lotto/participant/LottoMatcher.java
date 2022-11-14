package lotto.participant;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.*;

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
            countOfMatchedNumbers += lottoNumbers.contains(winningNumber) ? 1 : 0;
        }
        return countOfMatchedNumbers;
    }

    private boolean checkIfBonusNumberMatch(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        return lottoNumbers.contains(winningLotto.getBonusNumber());
    }

    private void saveResult(int numberOfMatchedLottoNumber, boolean bonus) {
        if (numberOfMatchedLottoNumber == 6) {
            rankCounts.put(FIRST_SIX_MATCHED, rankCounts.getOrDefault(FIRST_SIX_MATCHED, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 5 && bonus) {
            rankCounts.put(SECOND_FIVE_WITH_BONUS, rankCounts.getOrDefault(SECOND_FIVE_WITH_BONUS, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 5) {
            rankCounts.put(THIRD_FIVE_MATCHED, rankCounts.getOrDefault(THIRD_FIVE_MATCHED, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 4) {
            rankCounts.put(FOURTH_FOUR_MATCHED, rankCounts.getOrDefault(FOURTH_FOUR_MATCHED, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 3) {
            rankCounts.put(FIFTH_THREE_MATCHED, rankCounts.getOrDefault(FIFTH_THREE_MATCHED, 0) + 1);
        }
    }
}
