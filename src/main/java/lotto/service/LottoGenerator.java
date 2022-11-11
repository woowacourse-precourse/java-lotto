package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static constants.Constants.*;

public class LottoGenerator {

    public List<Integer> generateRandomNums() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_NUMS_SIZE);
    }

}
