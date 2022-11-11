package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public Lotto publish() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
