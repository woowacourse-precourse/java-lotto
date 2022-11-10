package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoNumberStatistic;

public class Machine {
    public Machine() {
    }

    public Lotto generateSingleLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LottoNumberStatistic.MIN_NUMBER.getValue(),
                LottoNumberStatistic.MAX_NUMBER.getValue(), LottoNumberStatistic.NUMBER_OF_LOTTERY_NUMBERS.getValue());
        return new Lotto(randomNumbers);
    }
}
