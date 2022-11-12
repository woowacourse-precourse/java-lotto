package lotto.domain;

import static lotto.constant.Rank.FIVE_MATCHES_WITHOUT_BONUS;
import static lotto.constant.Rank.FIVE_MATCHES_WITH_BONUS;
import static lotto.constant.Rank.FOUR_MATCHES;
import static lotto.constant.Rank.SIX_MATCHES;
import static lotto.constant.Rank.THREE_MATCHES;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.constant.Rank;

public class Calculator {

    public List<Integer> calculateMatchResults(LottoGroup lottoGroup,
            WinningLotto winningLotto, BonusNumber bonusNumber) {
        Comparator comparator = new Comparator();
        List<Integer> matchResults = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        int matchCount = 0;
        for (Lotto lotto : lottoGroup.getLottoGroup()) {
            matchCount = comparator.getMatchCount(lotto, winningLotto.getNumbers());
            if (matchCount == 5) {
                setMatchResultsWithBonusNumber(bonusNumber.getNumber(), comparator, matchResults, lotto);
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
            return THREE_MATCHES.getIndex();
        }
        if (matchCount == 4) {
            return FOUR_MATCHES.getIndex();
        }
        return SIX_MATCHES.getIndex();
    }

    private void setMatchResultsWithBonusNumber(int bonusNumber, Comparator comparator, List<Integer> matchResults,
            Lotto lotto) {
        int index = getIndexWithBonusNumber(bonusNumber, lotto, comparator);
        matchResults.set(index, matchResults.get(index) + 1);
    }

    private int getIndexWithBonusNumber(int bonusNumber, Lotto lotto, Comparator comparator) {
        if (!comparator.hasBonusNumber(lotto, bonusNumber)) {
            return FIVE_MATCHES_WITHOUT_BONUS.getIndex();
        }
        return FIVE_MATCHES_WITH_BONUS.getIndex();
    }

    public int calculateProfit(List<Integer> matchResults) {
        int profit = 0;
        List<Integer> prizeMoneys = Stream.of(Rank.values())
                .map(Rank::getPrize)
                .collect(Collectors.toList());
        for (int index = 0; index < matchResults.size(); index++) {
            if (matchResults.get(index) > 0) {
                profit += (matchResults.get(index) * prizeMoneys.get(index));
            }
        }
        return profit;
    }

    public double calculateEarningsRate(int purchaseCost, int profit) {
        double earningsRate = ((double) profit / purchaseCost) * 100;
        return (double) Math.round(earningsRate * 10) / 10;
    }
}
