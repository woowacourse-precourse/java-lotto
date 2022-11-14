package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoManager {
    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
