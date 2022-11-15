package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.utils.constants.LottoConstant;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_LOTTO.getNumber(),
                LottoConstant.MAX_LOTTO.getNumber(),
                LottoConstant.LOTTO_SIZE.getNumber()
        );
        Collections.sort(numbers);
        return numbers;
    }
}
