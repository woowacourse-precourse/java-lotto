package lotto.model;

import java.util.*;

public class WinningInfo {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final int FOURTH = 3;
    private static final int FIFTH = 4;
    private static final Map<Prize, Integer> indices = new HashMap<>();
    private final List<Integer> winningCounts = new ArrayList<>();

    static {
        indices.put(Prize.FIRST, FIRST);
        indices.put(Prize.SECOND, SECOND);
        indices.put(Prize.THIRD, THIRD);
        indices.put(Prize.FOURTH, FOURTH);
        indices.put(Prize.FIFTH, FIFTH);
    }

    public WinningInfo() {
        for (int index = 0; index < Prize.values().length; index++) {
            winningCounts.add(0);
        }
    }

    public void increaseWinningCount(Prize prize) {
        int index = indices.get(prize);

        winningCounts.set(index, winningCounts.get(index) + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningInfo other = (WinningInfo) o;
        return Objects.equals(winningCounts, other.winningCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningCounts);
    }
}
