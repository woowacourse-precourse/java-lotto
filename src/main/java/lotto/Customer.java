package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public void purchaseLotto(int money) {
        int count = money / Lotto.PRICE;
        LottoManager lottoManager = new LottoManager();
        for (int i = 0; i < count; i++) {
            lottoTickets.add(lottoManager.issue());
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
