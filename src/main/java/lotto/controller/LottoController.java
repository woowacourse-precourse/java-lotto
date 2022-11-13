package lotto.controller;

import lotto.controller.dto.UserInputMoneyDto;
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
		try {
			UserInputMoneyDto userInputMoneyDto = getUserInputMoneyDto();
			UserLottoDto userLottoDto = getUserLottoDto(userInputMoneyDto);
			WinnerNumberDto winnerNumberDto = getWinnerNumberDto();
			activateStatisticsService(userInputMoneyDto, userLottoDto, winnerNumberDto);
		} catch (RuntimeException e) {
			outputView.printError(e.getMessage());
		}
	}

	private UserInputMoneyDto getUserInputMoneyDto() {
		UserInputMoneyDto userInputMoneyDto = inputController.getUserMoneyNumber();
		outputView.printLottoCount(userInputMoneyDto.getUserTicketCount());
		return userInputMoneyDto;
	}

	private UserLottoDto getUserLottoDto(UserInputMoneyDto userInputMoneyDto) {
		UserLottoDto userLottoDto = lottoService.makeRandomLottoNumber(userInputMoneyDto.getUserTicketCount());
		outputView.printUserLotto(userLottoDto.getUserLotto());
		return userLottoDto;
	}

	private WinnerNumberDto getWinnerNumberDto() {
		WinnerNumberDto winnerNumberDto = inputController.getAnswerNumber();
		inputController.getBonusNumber(winnerNumberDto);
		return winnerNumberDto;
	}

	private void activateStatisticsService(UserInputMoneyDto userInputMoneyDto, UserLottoDto userLottoDto,
		WinnerNumberDto winnerNumberDto) {
		Double yield = statisticsService.updateStatistics(userLottoDto, winnerNumberDto,
			userInputMoneyDto.getInputPrice());
		outputView.printUserStatistics(yield);
	}

}
