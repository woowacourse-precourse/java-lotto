package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User {
    private int bonusNum;

    public static List<Lotto> randomLotto(int price) {
        List<Lotto> nums = new ArrayList<>();

        for (int i=0; i<price; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            nums.add(lotto);
        }

        return nums;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
