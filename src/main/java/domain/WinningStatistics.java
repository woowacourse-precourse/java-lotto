package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final List<List<Integer>> randomNumbersContainer;
    private final List<Integer> winningNumber;
    private final int bonus;
    private static final Map<Integer, Integer> comparisonTarget;
    static {
        comparisonTarget = new HashMap<>();
        comparisonTarget.put(3000,0);
        comparisonTarget.put(4000,0);
        comparisonTarget.put(5000,0);
        comparisonTarget.put(5100,0);
        comparisonTarget.put(6000,0);
    }

    public WinningStatistics(List<List<Integer>> randomNumbersContainer, List<Integer> winningNumber, int bonus) {
        this.randomNumbersContainer = randomNumbersContainer;
        this.winningNumber = winningNumber;
        this.bonus = bonus;
    }

    public List<Integer> getWinningStatistics(List<List<Integer>> randomNumbersContainer, List<Integer> winningNumber, int bonus) {
        calculateStatistics(randomNumbersContainer,winningNumber,bonus);

    }

    private void calculateStatistics(List<List<Integer>> randomNumbersContainer, List<Integer> winningNumber, int bonus) {
        for (List<Integer> list : randomNumbersContainer) {
            int statistics = getStatistics(list, winningNumber, bonus);
            Integer score = comparisonTarget.get(statistics);
            if (score == null) {
                continue;
            }
            comparisonTarget.put(statistics, score + 1);
        }
    }

    private int getStatistics(List<Integer> lotto,List<Integer> winningNumber, int bonus) {
        int winningScore = getWinningScore(lotto,winningNumber);
        int bonusScore = getBonusScore(lotto,bonus);
        return winningScore * 1000 + bonusScore * 100;
    }

}
