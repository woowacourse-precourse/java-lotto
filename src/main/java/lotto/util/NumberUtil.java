package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberUtil {
    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
