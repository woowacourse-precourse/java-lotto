package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Random {
    public List<Integer> randomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
