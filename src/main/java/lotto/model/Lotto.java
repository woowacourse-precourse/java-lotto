package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Setting;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static Lotto makeRandom() {
        List<Integer> randoms = Randoms.
                pickUniqueNumbersInRange(Setting.MIN_LOTTO_NUMBER, Setting.MAX_LOTTO_NUMBER, Setting.LOTTO_SIZE);
        List<Integer> numbers = new ArrayList<>(randoms);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
