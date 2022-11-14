package lotto.controller;

import java.util.Map;
import lotto.model.domain.Rank;
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
        WinningNumberDto winningLotto = announceWinningLotto();

        computeWinningStatistics(lottosDto, winningLotto);
    }

    private LottosDto buyLotto() {
        String money = InputView.requestMoney();
        LottosDto lottosDto = lottoService.createLottos(money);

        OutputView.printLottos(lottosDto.toString());
        return lottosDto;
    }

    private WinningNumberDto announceWinningLotto() {
        String winningNumber = InputView.requestWinningNumber();
        String bonusNumber = InputView.requestBonusNumber();

        return lottoService.createWinningNumber(winningNumber, bonusNumber);
    }

    private void computeWinningStatistics(LottosDto lottosDto, WinningNumberDto winningNumberDto) {
        WinningStatisticsDto winningStatisticsDto = lottoService.createWinningStatistics(lottosDto, winningNumberDto);
        Map<Rank, Integer> rankAndRankCount = winningStatisticsDto.getRankAndRankCount();
        double totalYield = winningStatisticsDto.getTotalYield();

        OutputView.printWinningStatistics(rankAndRankCount, totalYield);
    }
}
