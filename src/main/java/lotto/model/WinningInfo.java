package lotto.model;

import java.util.*;

public class WinningInfo {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final int FOURTH = 3;
    private static final int FIFTH = 4;
    private static final Map<LottoPrize, Integer> indices = new HashMap<>();
    private final List<Integer> winningCounts;

    static {
        indices.put(LottoPrize.FIRST, FIRST);
        indices.put(LottoPrize.SECOND, SECOND);
        indices.put(LottoPrize.THIRD, THIRD);
        indices.put(LottoPrize.FOURTH, FOURTH);
        indices.put(LottoPrize.FIFTH, FIFTH);
    }

    public WinningInfo() {
        winningCounts = new ArrayList<>();

        for (int index = 0; index < LottoPrize.values().length - 1; index++) {
            winningCounts.add(0);
        }
    }

    public WinningInfo(List<Integer> winningCounts) {
        this.winningCounts = winningCounts;
    }

    public void increaseWinningCount(LottoPrize lottoPrize) {
        int index = indices.get(lottoPrize);

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

    @Override
    public String toString() {
        String result = "당첨 통계\n---\n" +
                String.format("3개 일치 (5,000원) - %d개\n", winningCounts.get(FIFTH)) +
                String.format("4개 일치 (50,000원) - %d개\n", winningCounts.get(FOURTH)) +
                String.format("5개 일치 (1,500,000원) - %d개\n", winningCounts.get(THIRD)) +
                String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winningCounts.get(SECOND)) +
                String.format("6개 일치 (2,000,000,000원) - %d개\n", winningCounts.get(FIRST));

        return result;
    }
}
