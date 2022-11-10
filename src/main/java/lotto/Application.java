package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Bonus bonus = new Bonus(Randoms.pickUniqueNumbersInRange(1, 45, 1));
//        System.out.println(lotto.getNumbers());
        lotto.getNumbers();
        while (bonus.getBonusNum().contains(lotto)) {
            bonus.getBonusNum();
        }
        System.out.println(lotto.getNumbers());
        System.out.println(bonus.getBonusNum());

    }
}
