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
		LottoBuyingInfo lottoBuyingInfo = getLottoBuyingInfo();

		List<Lotto> lottos = createLottos(lottoBuyingInfo);

		WinningInfo winningInfo = getWinningInfo();

		ScoreInfo scoreInfo = getScoreInfo(lottos, winningInfo);

		calculateProfit(lottoBuyingInfo, scoreInfo);
	}

	private LottoBuyingInfo getLottoBuyingInfo() {
		String moneyInput = inputView.getMoney();
		LottoBuyingInfo lottoBuyingInfo = ConverterHolder.convert(moneyInput, LottoBuyingInfo.class);
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
		Double profit = lottoService.calculateProfitBy(lottoBuyingInfo, scoreInfo);
		outputView.printProfitPercentageMessage(profit);
	}
}
