package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.constance.LottoConstance.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현

    public static Lotto generateLotto() {
        return new Lotto(createRandomNumbers());
    }

    private static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER, REPEATABLE);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
