package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.Rank.*;

public class LottoMatcher {

    private final Map<Rank, Integer> prize = Map.of(
            FIRST_SIX_MATCHED, 2_000_000_000,
            SECOND_FIVE_WITH_BONUS, 30_000_000,
            THIRD_FIVE_MATCHED, 1_500_000,
            FOURTH_FOUR_MATCHED, 50_000,
            FIFTH_THREE_MATCHED, 5_000);

    private List<Lotto> publishedLottos;
    private WinningLotto winningLotto;
    private List<Rank> results;

    public LottoMatcher(List<Lotto> publishedLottos, WinningLotto winningLotto) {
        this.publishedLottos = publishedLottos;
        this.winningLotto = winningLotto;
        results = new ArrayList<>();
        matchAllLottos();
    }

    private void matchAllLottos() {
        // 각각의 lotto 와 winning lotto 의 일치율을 확인
    }

    private void matchLotto(Lotto lotto) {
        int countOfMatchedNumbers = countWinningLottoNumbers(lotto.getNumbers());
        boolean bonusNumberIsMatched = checkIfBonusNumberMatch(lotto.getNumbers());
        saveResult(countOfMatchedNumbers, bonusNumberIsMatched);
    }

    private int countWinningLottoNumbers(List<Integer> lottoNumbers) {
        int countOfMatchedNumbers = 0;
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();
        for (Integer winningNumber : winningNumbers) {
            countOfMatchedNumbers += lottoNumbers.contains(winningNumber) ? 1 : 0;
        }
        return countOfMatchedNumbers;
    }

    private boolean checkIfBonusNumberMatch(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(winningLotto.getBonusNumber());
    }

    private void saveResult(int numberOfMatchedLottoNumber, boolean bonus) {
        if (numberOfMatchedLottoNumber == 6) {
            results.add(FIRST_SIX_MATCHED);
        } else if (numberOfMatchedLottoNumber == 5 && bonus) {
            results.add(SECOND_FIVE_WITH_BONUS);
        } else if (numberOfMatchedLottoNumber == 5) {
            results.add(THIRD_FIVE_MATCHED);
        } else if (numberOfMatchedLottoNumber == 4) {
            results.add(FOURTH_FOUR_MATCHED);
        } else if (numberOfMatchedLottoNumber == 3) {
            results.add(FIFTH_THREE_MATCHED);
        }
    }

    public List<Rank> getResults() {
        return results;
    }
}
