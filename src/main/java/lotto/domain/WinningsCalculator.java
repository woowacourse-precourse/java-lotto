package lotto.domain;

import java.util.*;

public class WinningsCalculator {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningsCalculator(List<Integer> numbers, int number) {
        this.winningNumbers = new Lotto(numbers).getNumbers();
        this.bonusNumber = number;
    }

    public Map<String, Integer> countLottoRankings(List<List<Integer>> lottoPapers) {
        Map<String, Integer> rankingCounts = new HashMap<>() {
            {
                put("FIRST_PLACE", 0);
                put("SECOND_PLACE", 0);
                put("THIRD_PLACE", 0);
                put("FOURTH_PLACE", 0);
                put("FIFTH_PLACE", 0);
            }
        };
        for (List<Integer> lotto : lottoPapers) {
            int winningCount = countMatchingWinningNumbers(lotto);
            int bonusCount = countMatchingBonusNumbers(lotto);
            addRankingCounts(rankingCounts, winningCount, bonusCount);
        }
        return rankingCounts;
    }

    public void addRankingCounts(Map<String, Integer> rankingCounts, int winningCount, int bonusCount) {
        try {
            WinningsCalculatorType rankingType = WinningsCalculatorType.selectRankingType(winningCount, bonusCount);
            if (rankingType.name() == "NO_RANK") {
                return;
            }
            rankingCounts.put(rankingType.name(), rankingCounts.get(rankingType.name()) + 1);
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public int countMatchingWinningNumbers(List<Integer> lotto) {
        int winningCount = 0;
        for (Integer number : winningNumbers) {
            if (isExistentNumber(lotto, number)) {
                winningCount++;
            }
        }
        return winningCount;
    }

    public int countMatchingBonusNumbers(List<Integer> lotto) {
        if (isExistentNumber(lotto, bonusNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean isExistentNumber(List<Integer> numbers, int targetNumber) {
        return Collections.binarySearch(numbers, targetNumber) >= 0;
    }
}