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
        if (numberOfMatchedLottoNumber == 6) {
            rankCounts.put(Rank.FIRST_SIX_MATCHED, rankCounts.getOrDefault(Rank.FIRST_SIX_MATCHED, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 5 && bonus) {
            rankCounts.put(Rank.SECOND_FIVE_WITH_BONUS, rankCounts.getOrDefault(Rank.SECOND_FIVE_WITH_BONUS, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 5) {
            rankCounts.put(Rank.THIRD_FIVE_MATCHED, rankCounts.getOrDefault(Rank.THIRD_FIVE_MATCHED, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 4) {
            rankCounts.put(Rank.FOURTH_FOUR_MATCHED, rankCounts.getOrDefault(Rank.FOURTH_FOUR_MATCHED, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 3) {
            rankCounts.put(Rank.FIFTH_THREE_MATCHED, rankCounts.getOrDefault(Rank.FIFTH_THREE_MATCHED, 0) + 1);
        }
    }
}
