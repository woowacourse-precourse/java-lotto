package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ConstValue;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.List;

public class IssuingMachine {
    public List<Lotto> allIssuedLottery = new ArrayList<>();

    public List<Lotto> makeLotteryList(int quantity) {
        for (int i = 0; i < quantity; i++) {
            List<Integer> lotteryNumbers = makeOneLottery();
            Lotto lotto = new Lotto(lotteryNumbers);
            allIssuedLottery.add(lotto);
        }

        return allIssuedLottery;
    }

    private List<Integer> makeOneLottery() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(ConstValue.Numbers.MIN_LOTTO_NUM, ConstValue.Numbers.MAX_LOTTO_NUM, ConstValue.Numbers.LOTTO_LENGTH);

        return integers;
    }
}
