package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Lotto> lotteryTickets = new ArrayList<>();
    public void purchaseLotto(int money) {
        int count = money / Lotto.PRICE;
        LottoManager lottoManager = new LottoManager();
        for (int i = 0; i < count; i++) {
            lotteryTickets.add(lottoManager.issue());
        }
    }

    public List<Lotto> getLotteryTickets() {
        return this.lotteryTickets;
    }
}
