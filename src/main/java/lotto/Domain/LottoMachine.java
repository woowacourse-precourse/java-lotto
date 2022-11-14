package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static List<Lotto> publishLotto(int count) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lotto;
    }
}
