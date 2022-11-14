package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoRank;
import lotto.view.LottoGameView;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final LottoGameView lottoGameView;
    private final Customer customer;

    public LottoGame(LottoGameView lottoGameView, Customer customer) {
        this.lottoGameView = lottoGameView;
        this.customer = customer;
    }

    public void play() {
        try {
            Lottos lottos = customer.purchaseLottos(lottoGameView.inputMoney());

            lottoGameView.printLottos(lottos);

            Map<LottoRank, Integer> rankCounts = lottos.getRankCounts(
                    customer.generateWinningNumber(
                            lottoGameView.inputWinningNumbers(),
                            lottoGameView.inputBonusNumber()));

            lottoGameView.printWinningResult(rankCounts);
            lottoGameView.printRateOfReturn(
                    lottos.getRateOfReturn(lottos.getTotalPrizeMoney(rankCounts)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
