package lotto.domain;

import java.util.*;

public class WinningsCalculator {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningsCalculator(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplicateNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers).getNumbers();
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(List<Integer> winningNumbers, int bonusNumber) {
        String DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호와 보너스 번호가 중복됩니다.";
        if (
                winningNumbers.stream()
                        .anyMatch(number -> number.equals(bonusNumber))
        ) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    public Map<String, Integer> countLottoRankings(List<List<Integer>> lottoPapers) {
        Map<String, Integer> rankingCounts = initializeMap();

        for (List<Integer> lotto : lottoPapers) {
            int winningCount = countMatchingWinningNumbers(lotto);
            int bonusCount = countMatchingBonusNumbers(lotto);
            addRankingCounts(rankingCounts, winningCount, bonusCount);
        }
        return rankingCounts;
    }

    private Map<String, Integer> initializeMap() {
        return new HashMap<>() {
            {
                put("FIRST_PLACE", 0);
                put("SECOND_PLACE", 0);
                put("THIRD_PLACE", 0);
                put("FOURTH_PLACE", 0);
                put("FIFTH_PLACE", 0);
            }
        };
    }

    public void addRankingCounts(Map<String, Integer> rankingCounts, int winningCount, int bonusCount) {
        try {
            WinningsCalculatorType rankingType = WinningsCalculatorType.selectRankingType(winningCount, bonusCount);
            if (rankingType.name() == "NO_RANK") {
                return;
            }
            rankingCounts.put(rankingType.name(), rankingCounts.get(rankingType.name()) + 1);
        } catch (Exception error) {
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

    public long calculateTotalWinnings(Map<String, Integer> rankingCounts) {
        long totalWinnings = 0L;
        Set<Map.Entry<String, Integer>> entries = rankingCounts.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() > 0) {
                String rankingName = entry.getKey();
                WinningsCalculatorType rankingType = WinningsCalculatorType.valueOf(rankingName);
                totalWinnings += rankingType.calculateWinnings(entry.getValue());
            }
        }
        return totalWinnings;
    }

    public double calculateRateOfReturn(long totalWinnings, long payment) {
        return Math.round(((double) totalWinnings / payment) * 1000) / 10.0;
    }
}