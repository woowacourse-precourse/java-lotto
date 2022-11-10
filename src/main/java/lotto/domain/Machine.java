package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoStatistic;

public class Machine {
    public Machine() {
    }
    //public List<Lotto> buyLotto(long money){

    //}
    public Lotto generateSingleLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LottoStatistic.MIN_NUMBER.getValue(),
                LottoStatistic.MAX_NUMBER.getValue(), LottoStatistic.NUMBER_OF_LOTTERY_NUMBERS.getValue());
        return new Lotto(randomNumbers);
    }
}
