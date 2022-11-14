package lotto;

import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int checkLotto(List<Integer> winner) {
        int matchCounts = 0;
        for (int value : winner) {
            if (numbers.contains(value)) {
                matchCounts++;
            }
        }
        return matchCounts;
    }

}
