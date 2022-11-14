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

        List<Lotto> lottos = lottoForPayment(lottoShop, money);
        WinningLottoNumber winningLottoNumberFor = getWinningLottoNumber(lottoShop, inputView);

        LottoRankAggregation lottoRankCombine = new LottoRankAggregation();
        ResponseRankAggregation responseRankAggregation = lottoRankCombine.rankAggregation(lottos, winningLottoNumberFor);

        WinningHistoryView.showRankAggregation(responseRankAggregation, payment);
    }

    private WinningLottoNumber getWinningLottoNumber(LottoShop lottoShop, InputView inputView) {
        String winningNumberData = inputView.push2();
        String bonusNumberData = inputView.push3();
        WinningLottoNumber winningLottoNumberFor = lottoShop.createWinningLottoNumberFor(winningNumberData, bonusNumberData);
        return winningLottoNumberFor;
    }

    private List<Lotto> lottoForPayment(LottoShop lottoShop, Money money) {
        List<Lotto> lottos = lottoShop.createLottoForPayment(money);
        ConsumerLottoNumberView.show(lottos);
        return lottos;
    }
}
