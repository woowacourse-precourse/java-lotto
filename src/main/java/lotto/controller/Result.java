package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Win;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Compare {
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
            Compare.compare(winLotto, lotto);
            Compare.compareBonus(bonusNum, lotto);
            Win win = Win.getWin(lotto.getCorrectCount(), lotto.isBonus());
            win.plusWin(win);
        }
        return Win.getWins();
    }
}
