package lotto.controller;

import lotto.util.LottoRank;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoCompany;
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
            List<LottoRank> ranks = getLottoRanks(lottos);

            lottoGameView.printWinningResult(lottoCompany.getRankCount(ranks));
            lottoGameView.printRateOfReturn(lottoCompany.getRateOfReturn(money, lottoCompany.getTotalPrizeMoney(ranks)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<LottoRank> getLottoRanks(List<Lotto> lottos) {
        List<Integer> winningNumbers = lottoGameView.inputWinningNumbers();
        int bonusNumber = lottoGameView.inputBonusNumber();

        return lottoCompany
                .generateWinningNumber(winningNumbers, bonusNumber)
                .getRanks(lottos);
    }
}
