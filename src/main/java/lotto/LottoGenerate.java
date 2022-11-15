package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerate {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUM_LENGTH = 6;

    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, NUM_LENGTH);
        return new Lotto(numbers);
    }

}
