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
        try {
            int money = lottoGameView.inputMoney();
            List<Lotto> lottos = customer.purchaseLottos(money);

            lottoGameView.printLottos(lottos);

            WinningNumber winningNumber = new WinningNumber(lottoGameView.inputWinningNumbers(), lottoGameView.inputBonusNumber());
            List<LottoRank> ranks = winningNumber.getRanks(lottos);
            double rateOfReturn = winningNumber.getRateOfReturn(money, winningNumber.getTotalPrizeMoney(ranks));

            lottoGameView.printWinningResult(ranks);
            lottoGameView.printRateOfReturn(rateOfReturn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
