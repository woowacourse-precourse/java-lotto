package lotto.participant;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.*;

public class LottoMatcher {

    private Map<Rank, Integer> results;

    public Map<Rank, Integer> matchAllLottos(List<Lotto> publishedLottos, WinningLotto winningLotto) {
        results = new HashMap<>();
        for (Lotto publishedLotto : publishedLottos) {
            matchLotto(publishedLotto, winningLotto);
        }
        return results;
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
            results.put(FIRST_SIX_MATCHED, results.getOrDefault(FIRST_SIX_MATCHED, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 5 && bonus) {
            results.put(SECOND_FIVE_WITH_BONUS, results.getOrDefault(SECOND_FIVE_WITH_BONUS, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 5) {
            results.put(THIRD_FIVE_MATCHED, results.getOrDefault(THIRD_FIVE_MATCHED, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 4) {
            results.put(FOURTH_FOUR_MATCHED, results.getOrDefault(FOURTH_FOUR_MATCHED, 0) + 1);
        } else if (numberOfMatchedLottoNumber == 3) {
            results.put(FIFTH_THREE_MATCHED, results.getOrDefault(FIFTH_THREE_MATCHED, 0) + 1);
        }
    }
}
