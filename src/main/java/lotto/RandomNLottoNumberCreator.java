package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.LottoValidationUtils.*;

public class RandomNLottoNumberCreator {

    public static List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, CRITERION_LOTTO_SIZE);
    }
}
