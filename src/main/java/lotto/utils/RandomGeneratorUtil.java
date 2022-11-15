package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.LottoConfig.*;

public class RandomGeneratorUtil {

    private RandomGeneratorUtil() {
    }

    public static List<Integer> generateDistinctSixRandomNumberInRangeOneToFortyFive() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(), MAX_LENGTH.getNumber());
    }

}
