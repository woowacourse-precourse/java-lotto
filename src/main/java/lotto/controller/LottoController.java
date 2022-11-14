package lotto.controller;

import lotto.dto.LottosDto;
import lotto.dto.WinningNumberDto;
import lotto.dto.WinningStatisticsDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        String money = InputView.requestMoney();
        LottosDto lottosDto = lottoService.createLottos(money);
        OutputView.printLottos(lottosDto.toString());
        String winningNumber = InputView.requestWinningNumber();
        String bonusNumber = InputView.requestBonusNumber();
        WinningNumberDto winningNumberDto = lottoService.createWinningNumber(winningNumber, bonusNumber);
        WinningStatisticsDto winningStatisticsDto = lottoService.createWinningStatistics(lottosDto, winningNumberDto);
        OutputView.printWinningStatistics(winningStatisticsDto.getRankAndRankCount());
        OutputView.printTotalYield(winningStatisticsDto.getTotalYield());
    }
}
