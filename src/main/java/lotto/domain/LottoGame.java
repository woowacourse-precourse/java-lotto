package lotto.domain;

import lotto.view.OutPutView;

public class LottoGame {

    private LottoShop lottoShop;
    private WinningLotto winningLotto;

    public LottoGame(LottoShop lottoShop, WinningLotto winningLotto) {
        this.lottoShop = lottoShop;
        this.winningLotto = winningLotto;
    }

    public void start(Customer customer, int amount) {
        lottoShop.sellTo(customer, amount);
    }

    public void winningHistory(Customer customer, int amount) {
        OutPutView.showRankAggregation(winningLotto.compareTo(customer), amount);
    }
}
