package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoReader {
    public List<LottoRank> rank(List<Lotto> lottos, Lotto drawnLotto, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> rank1Lotto(lotto, drawnLotto, bonusNumber))
                .collect(Collectors.toList());
    }

    private LottoRank rank1Lotto(Lotto lotto, Lotto drawnLotto, int bonusNumber) {
        int theNumberOfMatch = compare(lotto.getNumbers(), drawnLotto.getNumbers());
        boolean isBonusNumberMatched = lotto.getNumbers().contains((bonusNumber));
        return judgeRank(theNumberOfMatch, isBonusNumberMatched);
    }

    private int compare(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int theNumberOfMatch = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                theNumberOfMatch += 1;
            }
        }
        return theNumberOfMatch;
    }

    private LottoRank judgeRank(int theNumberOfMatch, boolean isBonusNumberMatches) {
        if (theNumberOfMatch == 3) {
            return LottoRank.FIFTH;
        }
        if (theNumberOfMatch == 4) {
            return LottoRank.FORTH;
        }
        if (theNumberOfMatch == 5 && !isBonusNumberMatches) {
            return LottoRank.THIRD;
        }
        if (theNumberOfMatch == 5 && isBonusNumberMatches) {
            return LottoRank.SECOND;
        }
        if (theNumberOfMatch == 6) {
            return LottoRank.FIRST;
        }
        return LottoRank.NOTHING;
    }
}
