package lotto;

import java.util.List;
import java.util.Collections;



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
    public List<Integer> sortLotto() {
        List<Integer> sorted = numbers;
        Collections.sort(sorted);
        return sorted;
    }

    public boolean checkBonusLotto(int bonus) {
        if (numbers.contains(bonus)) {
            return true;
        }
        return false;
    }
}
