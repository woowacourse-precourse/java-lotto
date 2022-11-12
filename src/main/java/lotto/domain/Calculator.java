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
        List<List<Integer>> groupOfUserLotteryNumbers = lottoGroup.getLottoNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonus = bonusNumber.getNumber();
        Comparator comparator = new Comparator();
        List<Integer> matchResults = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        int matchCount = 0;
        for (List<Integer> userLotteryNumbers : groupOfUserLotteryNumbers) {
            matchCount = comparator.getMatchCount(userLotteryNumbers, winningNumbers);
            if (matchCount == 5) {
                setMatchResultsWithBonusNumber(bonus, comparator, matchResults, userLotteryNumbers);
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
            List<Integer> userLotteryNumbers) {
        int index = getIndexWithBonusNumber(bonusNumber, userLotteryNumbers, comparator);
        matchResults.set(index, matchResults.get(index) + 1);
    }

    private int getIndexWithBonusNumber(int bonusNumber, List<Integer> userLotteryNumbers, Comparator comparator) {
        if (!comparator.hasBonusNumber(userLotteryNumbers, bonusNumber)) {
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
