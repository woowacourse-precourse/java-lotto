package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static LottoTickets buy(PurchaseAmount purchaseAmount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < purchaseAmount.getNumberOfAvailableBuyLotto(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            tickets.add(lotto);
        }
        return new LottoTickets(tickets);
    }
}