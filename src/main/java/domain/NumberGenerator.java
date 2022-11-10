package domain;

import camp.nextstep.edu.missionutils.Randoms;
import view.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    private Lotto lotto;
    private List<Integer> lottoValue;

    public NumberGenerator() {
        lottoValue = generateLotto();
        lotto = new Lotto(lottoValue);
    }

    public List<Integer> getLottoValue() {
        return this.lottoValue;
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

}
