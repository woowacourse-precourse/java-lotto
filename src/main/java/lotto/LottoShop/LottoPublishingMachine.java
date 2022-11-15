package lotto.LottoShop;

import lotto.LottoManagement.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Enum.Constant.*;

public class LottoPublishingMachine {
    public LottoPublishingMachine() {
    }

    public List<Lotto> publishLottoGroup(int lotto_amount) {
        List<Lotto> lotto_group = new ArrayList<>();

        for (int i = ZERO_INDEX.getIntValue(); i < lotto_amount; i++) {
            Lotto new_lotto = publishLotto(lotto_group);
            lotto_group.add(new_lotto);
        }
        return lotto_group;
    }

    private Lotto publishLotto(List<Lotto> lotto_group) {
        List<Integer> random_lotto_num
                = pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getIntValue(), LOTTO_NUMBER_MAX.getIntValue(), LOTTO_NUMBER_COUNT.getIntValue())
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());
        return new Lotto(random_lotto_num);
    }

}
