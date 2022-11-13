package lotto.controller;

import lotto.LottoRank;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoCompany;
import lotto.domain.WinningNumber;
import lotto.view.LottoGameView;

import java.util.*;

public class LottoGame {
    private final LottoGameView lottoGameView;
    private final Customer customer;
    private final LottoCompany lottoCompany;

    public LottoGame(LottoGameView lottoGameView, Customer customer, LottoCompany lottoCompany) {
        this.lottoGameView = lottoGameView;
        this.customer = customer;
        this.lottoCompany = lottoCompany;
    }

    public void play() {
        try {
            int money = lottoGameView.inputMoney();
            List<Lotto> lottos = customer.purchaseLottos(money);

            lottoGameView.printLottos(lottos);

            WinningNumber winningNumber = lottoCompany.generate(lottoGameView.inputWinningNumbers(), lottoGameView.inputBonusNumber());
            List<LottoRank> ranks = winningNumber.getRanks(lottos);
            double rateOfReturn = lottoCompany.getRateOfReturn(money, lottoCompany.getTotalPrizeMoney(ranks));

            lottoGameView.printWinningResult(ranks);
            lottoGameView.printRateOfReturn(rateOfReturn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
