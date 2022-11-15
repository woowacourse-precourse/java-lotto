package lotto;

import java.util.List;

public class LottoMatcher {

    public static MatchResult matchLotto(WinningLotto winningLotto, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        Integer countMatch = 0;
        for (Integer num : lottoNumbers) {
            if (winningNumbers.contains(num)) {
                countMatch++;
            }
        }

        Boolean bonusMatch = false;
        if (countMatch == 5) {
            bonusMatch = true;
        }

        return new MatchResult(countMatch, bonusMatch);
    }
}
