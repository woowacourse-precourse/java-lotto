package lotto;

import java.util.List;

public class Result {
    public static void compareLottoNumber(List<Lotto> myLotto, List<Integer> winningNumber, int bonusNumber) {
        for (Lotto lotto : myLotto) {
            int winning = countWinningNumber(lotto, winningNumber);
            boolean bonus = containBonusNumber(lotto, bonusNumber);
        }
    }

    public static int countWinningNumber(Lotto lotto, List<Integer> winningNumber) {
        int cnt = 0;
        for (int number : winningNumber) {
            cnt += containWinningNumber(lotto, number);
        }

        return cnt;
    }

    public static int containWinningNumber(Lotto lotto, int winningNumber) {
        if (lotto.containNumber(winningNumber)) {
            return 1;
        }
        return 0;
    }

    public static boolean containBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.containNumber(bonusNumber);
    }
}

