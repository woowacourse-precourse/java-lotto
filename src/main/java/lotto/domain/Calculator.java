package lotto.domain;

import static lotto.constant.SystemValue.FIVE_MATCHES_WITHOUT_BONUS_INDEX;
import static lotto.constant.SystemValue.FIVE_MATCHES_WITH_BONUS_INDEX;
import static lotto.constant.SystemValue.FOUR_MATCHES_INDEX;
import static lotto.constant.SystemValue.SIX_MATCHES_INDEX;
import static lotto.constant.SystemValue.THREE_MATCHES_INDEX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public List<Integer> calculateMatchResults(List<List<Integer>> groupOfUserLotteryNumbers,
            List<Integer> winningNumbers, int bonusNumber) {
        Comparator comparator = new Comparator();
        List<Integer> matchResults = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        int matchCount = 0;
        for (List<Integer> userLotteryNumbers : groupOfUserLotteryNumbers) {
            matchCount = comparator.getMatchCount(userLotteryNumbers, winningNumbers);
            if (matchCount == 5) {
                setMatchResultsWithBonusNumber(bonusNumber, comparator, matchResults, userLotteryNumbers);
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
            return THREE_MATCHES_INDEX;
        }
        if (matchCount == 4) {
            return FOUR_MATCHES_INDEX;
        }
        return SIX_MATCHES_INDEX;
    }

    private void setMatchResultsWithBonusNumber(int bonusNumber, Comparator comparator, List<Integer> matchResults,
            List<Integer> userLotteryNumbers) {
        int index = getIndexWithBonusNumber(bonusNumber, userLotteryNumbers, comparator);
        matchResults.set(index, matchResults.get(index) + 1);
    }

    private int getIndexWithBonusNumber(int bonusNumber, List<Integer> userLotteryNumbers, Comparator comparator) {
        if (!comparator.hasBonusNumber(userLotteryNumbers, bonusNumber)) {
            return FIVE_MATCHES_WITHOUT_BONUS_INDEX;
        }
        return FIVE_MATCHES_WITH_BONUS_INDEX;
    }

    public int calculateProfit(List<Integer> matchResults) {
        // TODO: 총 수익 반환
        return 0;
    }

    public double calculateEarningsRate() {
        // TODO: 총 수익률 반환
        return 0.0;
    }
}
