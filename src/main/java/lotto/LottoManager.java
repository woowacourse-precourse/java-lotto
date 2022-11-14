package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoManager {
    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.START_RANGE, Lotto.END_RANGE, Lotto.NUMBER_COUNT);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
