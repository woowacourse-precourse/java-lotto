package lotto.controller;

import lotto.LottoRank;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.view.LottoGameView;

import java.util.*;

public class LottoGame {

    private final LottoGameView lottoGameView;
    private final Customer customer;

    public LottoGame(LottoGameView lottoGameView, Customer customer) {
        this.lottoGameView = lottoGameView;
        this.customer = customer;
    }

    public void play() {
        int money = lottoGameView.inputMoney();
        List<Lotto> lottos = customer.purchaseLottos(money);
        lottoGameView.printLottos(lottos);
        WinningNumber winningNumber = new WinningNumber(lottoGameView.inputWinningNumbers(), lottoGameView.inputBonusNumber());
        List<LottoRank> ranks = winningNumber.getRanks(lottos);
        lottoGameView.printWinningResult(ranks);
        lottoGameView.printRateOfReturn(winningNumber.getRateOfReturn(money, winningNumber.getTotalPrizeMoney(ranks)));
    }
}
