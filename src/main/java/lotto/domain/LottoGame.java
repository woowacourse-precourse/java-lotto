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

        String pay = inputView.push();
        List<Lotto> lottos = lottoShop.createLottoForPayment(pay);

        ConsumerLottoNumberView.show(lottos);

        String winningNumberData = inputView.push2();
        String bonusNumberData = inputView.push3();

        WinningLottoNumber winningLottoNumberFor = lottoShop.createWinningLottoNumberFor(winningNumberData, bonusNumberData);

        LottoRankAggregation lottoRankCombine = new LottoRankAggregation();
        ResponseRankAggregation responseRankAggregation = lottoRankCombine.rankAggregation(lottos, winningLottoNumberFor);

        WinningHistoryView.showRankAggregation(responseRankAggregation, pay);
    }
}
