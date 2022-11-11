package lotto.utils;

import static lotto.constants.LottoConstant.VALID_LOTTERY_NUMBER_LENGTH;
import static lotto.constants.LottoConstant.VALID_MAX_RANGE;
import static lotto.constants.LottoConstant.VALID_MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(VALID_MIN_RANGE, VALID_MAX_RANGE, VALID_LOTTERY_NUMBER_LENGTH);
    }
}
