package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumbers implements Numbers{

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                Config.LOTTO_START_NUMBER,
                Config.LOTTO_END_NUMBER,
                Config.LOTTO_NUMBER_COUNT
        );
    }
}
