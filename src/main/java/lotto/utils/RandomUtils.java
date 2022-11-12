package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.entity.Lotto;

import java.util.List;

public class RandomUtils {
    public static List<Integer> getRandomLottoNumber(int start, int end, int amount) {
        return Randoms.pickUniqueNumbersInRange(start, end, amount);
    }

}
