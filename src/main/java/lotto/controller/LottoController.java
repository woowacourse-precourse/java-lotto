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

    public void run() {
        LottosDto lottosDto = buyLotto();
        WinningLottoDto winningLottoDto = announceWinningLotto();

        computeWinningStatistics(lottosDto, winningLottoDto);
    }

    private LottosDto buyLotto() {
        String money = InputView.requestMoney();
        LottosDto lottosDto = lottoService.createLottos(money);

        OutputView.printLottos(lottosDto.toString());
        return lottosDto;
    }

    private WinningLottoDto announceWinningLotto() {
        String winningNumber = InputView.requestWinningNumber();
        String bonusNumber = InputView.requestBonusNumber();

        return lottoService.createWinningNumber(winningNumber, bonusNumber);
    }

    private void computeWinningStatistics(LottosDto lottosDto, WinningLottoDto winningLottoDto) {
        WinningStatisticsDto winningStatisticsDto = lottoService.createWinningStatistics(lottosDto, winningLottoDto);

        OutputView.printWinningStatistics(winningStatisticsDto);
    }
}
