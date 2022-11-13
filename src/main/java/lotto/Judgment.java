package lotto;

import java.util.List;

public class Judgment {

    public static int correctCount(List<Integer> winningLotto, List<Integer> userLotto) {
        int countContainedNum = 0;

        for(int num : userLotto) {
            if (winningLotto.contains(num)) {
                countContainedNum++;
            }
        }

        return countContainedNum;
    }

    public static boolean hasBonusNumber(int bonusNumber, List<Integer> userLotto){
        return userLotto.contains(bonusNumber);
    }
}
