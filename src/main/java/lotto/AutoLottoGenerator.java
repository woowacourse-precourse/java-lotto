package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class AutoLottoGenerator {
    public static final int LOTTO_SIZE = 6;

    public static Lotto generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_VALUE, Lotto.MAX_VALUE, LOTTO_SIZE);
        return new Lotto(randomNumbers);
    }
}
