package domain;

import java.util.List;

public class WinningStatistics {
    private final List<List<Integer>> randomNumbersContainer;
    private final List<Integer> winningNumber;
    private final int bonus;

    public WinningStatistics(List<List<Integer>> randomNumbersContainer, List<Integer> winningNumber, int bonus) {
        this.randomNumbersContainer = randomNumbersContainer;
        this.winningNumber = winningNumber;
        this.bonus = bonus;
    }
}
