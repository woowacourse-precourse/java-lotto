package lotto.controller;

import java.util.List;

import lotto.domain.ScoreInfo;
import lotto.vo.Lotto;
import lotto.dto.WinningInfoDto;
import lotto.service.LottoService;
import lotto.system.holder.ConverterHolder;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.LottoBuyingInfo;
import lotto.vo.WinningInfo;

public class LottoController {
	private final InputView inputView;
	private final OutputView outputView;
	private final LottoService lottoService;

	public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.lottoService = lottoService;
	}

	public void runLotto() {
		String moneyInput = inputView.getMoney();
		LottoBuyingInfo lottoBuyingInfo = ConverterHolder.convert(moneyInput, LottoBuyingInfo.class);
		outputView.printLottoBuyingInfo(lottoBuyingInfo);

		List<Lotto> lottos = lottoService.createLottos(lottoBuyingInfo);
		outputView.printLottos(lottos);

		String winningNumbersInput = inputView.getWinningNumbers();
		String bonusInput = inputView.getBonus();
		WinningInfoDto winningInfoDto = new WinningInfoDto(winningNumbersInput, bonusInput);

		WinningInfo winningInfo = winningInfoDto.toWinningInfo();

		ScoreInfo scoreInfo = lottoService.makeScoreInfoBy(lottos, winningInfo);
		outputView.printScoreMessage(scoreInfo);

		Double profit = lottoService.calculateProfitBy(lottoBuyingInfo, scoreInfo);
		outputView.printProfitPercentageMessage(profit);
	}
}
