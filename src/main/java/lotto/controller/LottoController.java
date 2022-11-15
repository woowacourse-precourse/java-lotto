package lotto.controller;

import lotto.model.dto.LottosDto;
import lotto.model.dto.WinningLottoDto;
import lotto.model.dto.WinningStatisticsDto;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void buyLotto() {
        String money = InputView.requestMoney();
        LottosDto lottosDto = lottoService.createLottos(money);
        OutputView.printLottos(lottosDto.toString());

        String winningNumber = InputView.requestWinningNumber();
        String bonusNumber = InputView.requestBonusNumber();
        WinningLottoDto winningLottoDto = lottoService.createWinningNumber(winningNumber, bonusNumber);

        WinningStatisticsDto winningStatisticsDto = lottoService.createWinningStatistics(lottosDto, winningLottoDto);
        OutputView.printWinningStatistics(winningStatisticsDto);
    }
}
