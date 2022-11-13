package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    protected final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto generator() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
