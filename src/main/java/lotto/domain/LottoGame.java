package lotto.domain;

import lotto.dto.ResponseRankAggregation;
import lotto.dto.WinningLottoNumber;
import lotto.service.LottoRankAggregation;
import lotto.view.ConsumerLottoNumberView;
import lotto.view.InputView;
import lotto.view.WinningHistoryView;

import java.util.List;

public class LottoGame {

    public void start() {
        LottoShop lottoShop = new LottoShop();
        InputView inputView = new InputView();

        String payment = inputView.push();
        Money money = new Money(payment);
        List<Lotto> lottos = lottoShop.createLottoForPayment(money);

        ConsumerLottoNumberView.show(lottos);

        String winningNumberData = inputView.push2();
        String bonusNumberData = inputView.push3();

        WinningLottoNumber winningLottoNumberFor = lottoShop.createWinningLottoNumberFor(winningNumberData, bonusNumberData);

        LottoRankAggregation lottoRankCombine = new LottoRankAggregation();
        ResponseRankAggregation responseRankAggregation = lottoRankCombine.rankAggregation(lottos, winningLottoNumberFor);

        WinningHistoryView.showRankAggregation(responseRankAggregation, payment);
    }
}
