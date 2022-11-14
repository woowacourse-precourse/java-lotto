package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {

    private static final Integer NUMBER_RANGE_BOT = 1;
    private static final Integer NUMBER_RANGE_TOP = 45;
    private static final Integer LOTTO_NUMBER_SIZE = 6;

    private static List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_BOT, NUMBER_RANGE_TOP, LOTTO_NUMBER_SIZE);
    }
}
