package lotto;

import java.util.HashSet;
import java.util.List;

public class CalculatingMachine {

    private final int overlapedCount;

    public CalculatingMachine(List<Integer> winningNumers, List<Integer> lottoes) {
        this.overlapedCount = getOverlapedNumber(winningNumers, lottoes).size();
    }

    public int getOverlapedCount() {
        return overlapedCount;
    }

    public HashSet<Integer> getOverlapedNumber(List<Integer> winningNumers, List<Integer> lottoes) {
        HashSet<Integer> winningNumber = new HashSet<>(winningNumers);
        HashSet<Integer> lotto = new HashSet<>(lottoes);
        HashSet<Integer> intersection = new HashSet<>(winningNumber);

        intersection.retainAll(lotto);

        return intersection;
    }
}
