package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Generator {
    public static List<Integer> makeRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
