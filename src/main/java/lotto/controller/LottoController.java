package lotto.controller;

import lotto.domain.UserPrice;
import lotto.domain.WinnerNumber;
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

		UserPrice userPrice = inputController.getUserMoneyNumber();
		if (isInvalidNumber(userPrice)) {
			return;
		}

		int lottoCount = userPrice.getUserTicketCount();
		outputView.printLottoCount(lottoCount);
		UserLottoDto userLottoDto = lottoService.makeRandomLottoNumber(lottoCount);
		outputView.printUserLotto(userLottoDto.getUserLotto());

		WinnerNumber winnerNumber = inputController.getAnswerNumber();
		if (isInvalidNumber(winnerNumber.getAnswerNumbers())) {
			return;
		}
		inputController.getBonusNumber(winnerNumber);
		if (isInvalidNumber(winnerNumber.getBonusNumber())) {
			return;
		}

		statisticsService.updateStatistics(userLottoDto, winnerNumber);
		outputView.printUserStatistics(userPrice.getInputPrice());

	}

	private boolean isInvalidNumber(Object number) {
		return number == null;
	}

}
