package lotto;

import java.util.List;

public class LottoMatcher {

    public static MatchResult matchLotto(WinningLotto winningLotto, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        Integer countMatch = countMatchNumber(lottoNumbers, winningNumbers);

        Integer bonusNum = winningLotto.getBonusNumber();
        Boolean bonusMatch = false;
        if (countMatch == 5 && lottoNumbers.contains(bonusNum)) {
            bonusMatch = true;
        }

        return new MatchResult(countMatch, bonusMatch);
    }

    private static Integer countMatchNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        Integer countMatch = 0;
        for (Integer num : lottoNumbers) {
            if (winningNumbers.contains(num)) {
                countMatch++;
            }
        }

        return countMatch;
    }
}
