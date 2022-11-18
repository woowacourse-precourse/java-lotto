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
        saveRank(countOfMatchedNumbers, bonusNumberIsMatched);
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

    private void saveRank(int numberOfMatchedLottoNumber, boolean bonus) {
        Rank rank = distinguishRank(numberOfMatchedLottoNumber, bonus);
        if (rank != null) {
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private Rank distinguishRank(int numberOfMatchedLottoNumber, boolean bonus) {
        if (numberOfMatchedLottoNumber == 6) {
            return Rank.FIRST_SIX_MATCHED;
        } else if (numberOfMatchedLottoNumber == 5 && bonus) {
            return Rank.SECOND_FIVE_WITH_BONUS;
        } else if (numberOfMatchedLottoNumber == 5) {
            return Rank.THIRD_FIVE_MATCHED;
        } else if (numberOfMatchedLottoNumber == 4) {
            return Rank.FOURTH_FOUR_MATCHED;
        } else if (numberOfMatchedLottoNumber == 3) {
            return Rank.FIFTH_THREE_MATCHED;
        }
        return null;
    }
}
