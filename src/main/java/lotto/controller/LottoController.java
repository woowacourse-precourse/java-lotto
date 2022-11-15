package lotto.controller;

import lotto.dto.ScoreInfo;
import lotto.dto.WinningInfoDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;
import lotto.vo.Profit;
import lotto.vo.WinningInfo;

import java.util.List;

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
		LottoBuyingInfo lottoBuyingInfo = getLottoBuyingInfo();

		List<Lotto> lottos = createLottos(lottoBuyingInfo);

		WinningInfo winningInfo = getWinningInfo();

		ScoreInfo scoreInfo = getScoreInfo(lottos, winningInfo);

		calculateProfit(lottoBuyingInfo, scoreInfo);
	}

	private LottoBuyingInfo getLottoBuyingInfo() {
		String moneyInput = inputView.getMoney();
		LottoBuyingInfo lottoBuyingInfo = new LottoBuyingInfo(moneyInput);
		outputView.printLottoBuyingInfo(lottoBuyingInfo);
		return lottoBuyingInfo;
	}

	private List<Lotto> createLottos(LottoBuyingInfo lottoBuyingInfo) {
		List<Lotto> lottos = lottoService.createLottos(lottoBuyingInfo);
		outputView.printLottos(lottos);
		return lottos;
	}

	private WinningInfo getWinningInfo() {
		String winningNumbersInput = inputView.getWinningNumbers();
		String bonusInput = inputView.getBonus();
		WinningInfoDto winningInfoDto = new WinningInfoDto(winningNumbersInput, bonusInput);
		return winningInfoDto.toWinningInfo();
	}

	private ScoreInfo getScoreInfo(List<Lotto> lottos, WinningInfo winningInfo) {
		ScoreInfo scoreInfo = lottoService.makeScoreInfoBy(lottos, winningInfo);
		outputView.printScoreMessage(scoreInfo);
		return scoreInfo;
	}

	private void calculateProfit(LottoBuyingInfo lottoBuyingInfo, ScoreInfo scoreInfo) {
		Profit profit = lottoService.calculateProfitBy(lottoBuyingInfo, scoreInfo);
		outputView.printProfitPercentageMessage(profit);
	}
}
