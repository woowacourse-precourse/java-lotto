package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoConfig.*;

public class RandomGeneratorUtil {

    private RandomGeneratorUtil() {
    }

    public static List<Integer> generateDistinctSixRandomNumberInRangeOneToFortyFive() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(), MAX_LENGTH.getNumber());
        Collections.sort(integers);
        return integers;
    }

}
