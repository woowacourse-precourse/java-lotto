package lotto.controller;

import static lotto.utils.Constants.*;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoGame {

    private List<Integer> generateLottoNumbers() {
        return pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, COUNT_OF_NUMBERS_IN_LOTTO);
    }
}
