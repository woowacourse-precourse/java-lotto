package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final List<List<Integer>> randomNumbersContainer;
    private final List<Integer> winningNumber;
    private final int bonus;
    public static final int LOTTO_SIZE = 6;
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
        List<Integer> calStatistics = countStatistics();
        return calStatistics;
    }

    private List<Integer> countStatistics() {
        List<Integer> statistics = new ArrayList<>();
        for (int i = 3000; i < 6001; i += 1000) {
            if (i == 5000) {
                statistics.add(comparisonTarget.get(i+100));
            }
            statistics.add(comparisonTarget.get(i));
        }
        return statistics;
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

    private int getWinningScore(List<Integer> lotto,List<Integer> winningNumber) {
        int number = 0;
        for(int i=0; i < LOTTO_SIZE; i++) {
            if (lotto.contains(winningNumber.get(i))) {
                number ++;
            }
        }
        return  number;
    }

    private int getBonusScore(List<Integer> lotto,int bonus) {
        int number = 0;
        if (lotto.contains(bonus)) {
            number ++;
        }
        return number;
    }
}
