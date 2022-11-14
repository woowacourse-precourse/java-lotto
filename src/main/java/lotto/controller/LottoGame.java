package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoGameView;

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

            WinningNumber winningNumber = customer.generateWinningNumber(lottoGameView.inputWinningNumbers(), lottoGameView.inputBonusNumber());

            lottoGameView.printWinningResult(lottos.getRankCounts(winningNumber));
            lottoGameView.printRateOfReturn(lottos.getRateOfReturn(lottos.getTotalPrizeMoney(lottos.getRanks(winningNumber))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
