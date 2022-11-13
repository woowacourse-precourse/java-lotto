package lotto.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberUtil {
    public static List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
