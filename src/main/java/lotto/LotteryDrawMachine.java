package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ENUMS.LotteryRules;

import java.util.ArrayList;
import java.util.List;

public class LotteryDrawMachine {
    User user;
    List<Lotto> lottos = new ArrayList<>();;

    public LotteryDrawMachine(User user) {
        this.user = user;
    }

    // 유저 금액만큼
    public List<Lotto> generateLotto() {
        for (int i = 0; i < user.numOfPurchasableLotto(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LotteryRules.START_INCLUSIVE.getNumber(),
                    LotteryRules.END_INCLUSIVE.getNumber(), LotteryRules.COUNT.getNumber());
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
