package lotto.controller;

import lotto.controller.request.CalculateWinningRequest;
import lotto.controller.request.LottoPurchaseRequest;
import lotto.controller.result.LottoPurchaseResult;
import lotto.controller.result.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import lotto.domain.statistics.Statistics;
import lotto.domain.winningnumber.WinningNumber;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(final LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoPurchaseResult purchaseLotto(final LottoPurchaseRequest request) {
        Money payment = request.getPayment();

        List<Lotto> lottos = lottoService.purchaseLotto(payment);
        return new LottoPurchaseResult(lottos);
    }

    public WinningResult calculateWinning(final CalculateWinningRequest request) {
        Money principle = request.getPrinciple();
        List<Lotto> lottos = request.getLottos();
        WinningNumber winningNumber = request.getWinningNumber();

        Statistics statistics = lottoService.judgeWinning(principle, lottos, winningNumber);
        return new WinningResult(statistics);
    }
}
