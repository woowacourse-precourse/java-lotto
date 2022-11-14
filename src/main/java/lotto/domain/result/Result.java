package lotto.domain.result;

import static lotto.domain.result.Rank.FIVE_MATCHES_WITHOUT_BONUS;
import static lotto.domain.result.Rank.FIVE_MATCHES_WITH_BONUS;
import static lotto.domain.result.Rank.FOUR_MATCHES;
import static lotto.domain.result.Rank.SIX_MATCHES;
import static lotto.domain.result.Rank.THREE_MATCHES;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.lottery.WinningLotto;

public class Result {

    private final Map<Integer, Integer> result = new HashMap<>();

    public Result(LottoGroup lottoGroup,
            WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> matchResults = calculateMatchResults(lottoGroup, winningLotto, bonusNumber);
        for (int rank = 0; rank < matchResults.size(); rank++) {
            result.put(rank, matchResults.get(rank));
        }
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }

    public List<Integer> calculateMatchResults(LottoGroup lottoGroup,
            WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> matchResults = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        int matchCount = 0;
        for (Lotto lotto : lottoGroup.getLottoGroup()) {
            matchCount = lotto.getMatchCount(winningLotto.getNumbers());
            if (matchCount == 5) {
                setMatchResultsWithBonusNumber(bonusNumber.getNumber(), matchResults, lotto);
                continue;
            }
            if (matchCount >= 3) {
                setMatchResults(matchCount, matchResults);
            }
        }
        return matchResults;
    }

    private void setMatchResults(int matchCount, List<Integer> matchResults) {
        int index = getIndex(matchCount);
        matchResults.set(index, matchResults.get(index) + 1);
    }

    private int getIndex(int matchCount) {
        if (matchCount == 3) {
            return THREE_MATCHES.getKey();
        }
        if (matchCount == 4) {
            return FOUR_MATCHES.getKey();
        }
        return SIX_MATCHES.getKey();
    }

    private void setMatchResultsWithBonusNumber(int bonusNumber, List<Integer> matchResults,
            Lotto lotto) {
        int index = getIndexWithBonusNumber(bonusNumber, lotto);
        matchResults.set(index, matchResults.get(index) + 1);
    }

    private int getIndexWithBonusNumber(int bonusNumber, Lotto lotto) {
        if (!lotto.hasBonusNumber(bonusNumber)) {
            return FIVE_MATCHES_WITHOUT_BONUS.getKey();
        }
        return FIVE_MATCHES_WITH_BONUS.getKey();
    }
}
