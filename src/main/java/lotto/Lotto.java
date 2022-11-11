package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(Constant.FIRST_NUMBER_IN_LOTTO,
            Constant.LAST_NUMBER_IN_LOTTO,
            Constant.LOTTO_SIZE);
        Collections.sort(lotto);
        return lotto;
    }

    // TODO: 추가 기능 구현
}
