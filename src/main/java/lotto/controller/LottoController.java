package lotto.controller;

import lotto.controller.dto.UserPriceDto;
import lotto.controller.dto.WinnerNumberDto;
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

		UserPriceDto userPriceDto = inputController.getUserMoneyNumber();
		if (isInvalidNumber(userPriceDto)) {
			return;
		}

		int lottoCount = userPriceDto.getUserTicketCount();
		outputView.printLottoCount(lottoCount);
		UserLottoDto userLottoDto = lottoService.makeRandomLottoNumber(lottoCount);
		outputView.printUserLotto(userLottoDto.getUserLotto());

		WinnerNumberDto winnerNumberDto = inputController.getAnswerNumber();
		if (isInvalidNumber(winnerNumberDto.getAnswerNumbers())) {
			return;
		}
		inputController.getBonusNumber(winnerNumberDto);
		if (isInvalidNumber(winnerNumberDto.getBonusNumber())) {
			return;
		}

		statisticsService.updateStatistics(userLottoDto, winnerNumberDto);
		outputView.printUserStatistics(userPriceDto.getInputPrice());

	}

	private boolean isInvalidNumber(Object number) {
		return number == null;
	}

}
