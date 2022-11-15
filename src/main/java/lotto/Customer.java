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

    public List<Rank> checkMyLotto(List<Integer> winningNumbers, int bonusNumber) {
        LottoManager lottoManager = new LottoManager();
        List<Rank> myRanks = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            Rank myRank = lottoManager.getRank(lotto, winningNumbers, bonusNumber);
            myRanks.add(myRank);
        }
        return myRanks;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
