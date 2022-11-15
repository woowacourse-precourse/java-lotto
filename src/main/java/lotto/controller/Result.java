package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Win;

import java.util.List;
import java.util.Map;

public class Result {
    public static void compare(Lotto win, Lotto lotto){
        for (int number : lotto.getNumbers()) {
            if (win.getNumbers().contains(number)) {
                lotto.addCorrectCount();
            }
        }
    }
    public static void compareBonus(int bonus, Lotto lotto) {
        if (lotto.getNumbers().contains(bonus)) {
            lotto.winBonus();
        }
    }

    public static Map<Win, Integer> countWins(Lotto winLotto, int bonusNum, List<Lotto> lottos) {
        Win.initWins();
        for (Lotto lotto : lottos) {
            Result.compare(winLotto, lotto);
            Result.compareBonus(bonusNum, lotto);
            Win win = Win.getWin(lotto.getCorrectCount(), lotto.isBonus());
            win.plusWin(win);
        }
        return Win.getWins();
    }

    /** 수익률 */
    public static double winningsRate(int input, Map<Win,Integer> wins) {
        double sum = 0;
        for (Win win : wins.keySet()) {
            sum +=  win.getWinnings() * wins.get(win);
        }
        return sum/input * 100;
    }
}
