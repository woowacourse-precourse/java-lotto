package controller;

import java.util.List;

public enum Winning {
    FIRST(2000000000, List.of(List.of(6, 0))),
    SECOND(30000000, List.of(List.of(5, 1))),
    THIRD(1500000, List.of(List.of(5, 0), List.of(4, 1))),
    FOURTH(50000, List.of(List.of(4, 0), List.of(3, 1))),
    FIFTH(5000, List.of(List.of(3, 0), List.of(2, 1)));

    private final int reward;
    private final List<List<Integer>> winningCount;

    Winning(int reward, List<List<Integer>> winningCount) {
        this.reward = reward;
        this.winningCount = winningCount;
    }

    public int getReward() {
        return reward;
    }

    public List<List<Integer>> getWinningCount() {
        return winningCount;
    }
}
