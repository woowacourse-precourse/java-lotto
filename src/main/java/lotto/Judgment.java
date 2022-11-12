package lotto;

import java.util.List;

public class Judgment {
    private final int LOTTO_NUM = 6;

    public int correctCount(List<Integer> winningLotto, List<Integer> userLotto) {
        int count = 0;
        for (int i = 0; i < LOTTO_NUM; i++) {
            if (winningLotto.contains(userLotto.get(i))) {
                count++;
            }
        }
        return count;
    }
}
