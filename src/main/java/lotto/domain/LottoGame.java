package lotto.domain;

import lotto.dto.RankAggregationDto;
import lotto.dto.WinningLottoNumberDto;
import lotto.service.LottoRankAggregation;
import lotto.view.ConsumerLottoNumberView;
import lotto.view.InputView;
import lotto.view.WinningHistoryView;

import java.util.List;

public class LottoGame {

    private final LottoRankAggregation lottoRankAggregation = new LottoRankAggregation();
    private final InputView inputView = new InputView();

    public void start() {
        LottoShop lottoShop = new LottoShop();
        Money money = getMoney();
        List<Lotto> lottos = getLottosForMoney(lottoShop, money);

        WinningLottoNumberDto winningLottoNumberDto = getWinningLottoNumber(lottoShop);
        RankAggregationDto rankAggregationDto = lottoRankAggregation.rankAggregation(lottos, winningLottoNumberDto);

        WinningHistoryView.showRankAggregation(rankAggregationDto, money.getPayment());
    }

    private Money getMoney() {
        String payment = inputView.requestMoney();
        return Money.of(payment);
    }

    private List<Lotto> getLottosForMoney(LottoShop lottoShop, Money money) {
        List<Lotto> lottos = lottoShop.createLottoForMoney(money);
        ConsumerLottoNumberView.show(lottos);
        return lottos;
    }

    private WinningLottoNumberDto getWinningLottoNumber(LottoShop lottoShop) {
        String winningNumberData = inputView.requestWinningNumbers();
        String bonusNumberData = inputView.requestBonusNumber();
        return lottoShop.createWinningLottoNumberFor(winningNumberData, bonusNumberData);
    }
}
