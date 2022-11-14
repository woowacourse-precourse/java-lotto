package lotto.controller;

import lotto.model.dto.LottosDto;
import lotto.model.dto.WinningNumberDto;
import lotto.model.dto.WinningStatisticsDto;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        LottosDto lottosDto = buyLotto();

        announceLottoWinningStatistics(lottosDto);
    }

    private LottosDto buyLotto() {
        String money = InputView.requestMoney();
        LottosDto lottosDto = lottoService.createLottos(money);

        OutputView.printLottos(lottosDto.toString());
        return lottosDto;
    }

    private void announceLottoWinningStatistics(LottosDto lottosDto) {
        String winningNumber = InputView.requestWinningNumber();
        String bonusNumber = InputView.requestBonusNumber();
        WinningNumberDto winningNumberDto = lottoService.createWinningNumber(winningNumber, bonusNumber);
        WinningStatisticsDto winningStatisticsDto = lottoService.createWinningStatistics(lottosDto, winningNumberDto);

        OutputView.printWinningStatistics(winningStatisticsDto);
    }
}
