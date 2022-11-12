package lotto;

import java.util.List;

public class Judgment {
    private static final int LOTTO_NUM = 6;

    public static int correctCount(List<Integer> winningLotto, List<Integer> userLotto) {
        int count = 0;
        for (int i = 0; i < LOTTO_NUM; i++) {
            if (winningLotto.contains(userLotto.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static boolean hasBonusNumber(int bonusNumber, List<Integer> userLotto){
        return userLotto.contains(bonusNumber);
    }
}
