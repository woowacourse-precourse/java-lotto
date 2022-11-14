package lotto.controller;

import static lotto.view.InputView.*;

import lotto.controller.dto.LottoPurchaseDto;
import lotto.domain.WinnerStatistics;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void run() {
        LottoPurchaseDto lottoPurchaseDto = lottoService.purchaseLotto(inputPaymentAmount());
        OutputView.printLottoPurchaseNumber(lottoPurchaseDto.getLottos().size());
        OutputView.printLottos(lottoPurchaseDto.getLottos());
        WinnerStatistics winnerStatistics = lottoService.calculateWinnerStatistics(inputWinnerNumber(),
                lottoPurchaseDto);
        OutputView.printWinnerStatistics(winnerStatistics.getStatisticsStore());
    }
}
