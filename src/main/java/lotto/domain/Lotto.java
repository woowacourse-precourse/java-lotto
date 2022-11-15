package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import static lotto.constant.Constants.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

    }

    public static Lotto generate() {
        return new Lotto(pickLottoNumbers());
    }

    private static List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN,MAX,MAX_COUNT);
    }
}
