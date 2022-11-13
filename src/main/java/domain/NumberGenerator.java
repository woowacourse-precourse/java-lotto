package domain;

import camp.nextstep.edu.missionutils.Randoms;
import view.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    private final Lotto lotto;

    public NumberGenerator() {
        lotto = new Lotto(generateLotto());
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public List<Integer> generateLotto() {
        List<Integer> generateLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(generateLotto);
        return generateLotto;
    }

}
