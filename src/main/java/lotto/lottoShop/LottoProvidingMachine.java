package lotto.lottoShop;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Enum.Constant.*;

public class LottoProvidingMachine {
    public LottoProvidingMachine() {
    }

    public List<Lotto> makeLottoGroup(int lotto_amount) {
        List<Lotto> lotto_group = new ArrayList<>();

        for (int i = ZERO.getIntValue(); i < lotto_amount; i++) {
            Lotto new_lotto = makeLotto(lotto_group);
            lotto_group.add(new_lotto);
        }
        return lotto_group;
    }

    private Lotto makeLotto(List<Lotto> lotto_group) {
        List<Integer> random_lotto_num = pickUniqueNumbersInRange(
                ZERO.getIntValue(), FOURTY_FIVE.getIntValue(), SIX.getIntValue()
        );
        return new Lotto(random_lotto_num);
    }

}
