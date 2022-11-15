package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BonusManager {
    private final List<Integer> bonusnumbers;

    public BonusManager(List<Integer> bonusnumbers) {
        validate(bonusnumbers);
        random(bonusnumbers);
        this.bonusnumbers = bonusnumbers;
    }

    private void validate(List<Integer> bonusnumbers) {
        if (bonusnumbers.size() != 1) {
            throw new IllegalArgumentException();
        }
    }

    public void random(List<Integer> bonusnumbers) {
        Randoms.pickUniqueNumbersInRange(1, 45, 1);
    }
}
