package lotto.controller;

import java.util.List;

import lotto.repository.dto.UserLottoDto;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.view.OutputView;

public class LottoController {

	private final LottoService lottoService;
	private final StatisticsService statisticsService;
	private final OutputView outputView;
	private final InputController inputController;

	public LottoController(LottoService lottoService, OutputView outputView,
		StatisticsService statisticsService, InputController inputController) {
		this.lottoService = lottoService;
		this.outputView = outputView;
		this.statisticsService = statisticsService;
		this.inputController = inputController;
	}

	public void startApplication() {

		Integer userMoneyNumber;
		try {
			userMoneyNumber = inputController.getUserMoneyNumber();
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return;
		}

		int lottoCount = userMoneyNumber / 1000;
		outputView.printLottoCount(lottoCount);
		UserLottoDto userLottoDto = lottoService.makeRandomLottoNumber(lottoCount);
		outputView.printUserLotto(userLottoDto.getUserLotto());

		List<Integer> answerNumber;
		Integer bonusNumber;
		try {
			answerNumber = inputController.getAnswerNumber();
			bonusNumber = inputController.getBonusNumber();
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return;
		}

		statisticsService.updateStatistics(userLottoDto, answerNumber, bonusNumber);
		outputView.printUserStatistics(userMoneyNumber);

	}

}
