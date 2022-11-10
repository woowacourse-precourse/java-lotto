package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    public void start() {
        Print.money();
        int lottoTickets = Input.purchaseAmount();
        Print.purchaseLotto(lottoTickets);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            List<Integer> random = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(random);
            lottos.add(new Lotto(random));
        }
    }
}
