package lotto.controller;

import lotto.controller.dto.UserInputMoneyDto;
import lotto.controller.dto.WinningNumberDto;
import lotto.repository.dto.UserLottoDto;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.service.dto.StatisticsDto;
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
			UserInputMoneyDto userInputMoneyDto = enterMoney();
			UserLottoDto userLottoDto = activateLottoMachine(userInputMoneyDto);
			WinningNumberDto winningNumberDto = enterWinningNumber();
			activateRankStatisticsService(userInputMoneyDto, userLottoDto, winningNumberDto);
		} catch (RuntimeException e) {
			outputView.printError(e.getMessage());
		}
	}

	private UserInputMoneyDto enterMoney() {
		UserInputMoneyDto userInputMoneyDto = inputController.getUserMoneyNumber();
		outputView.printLottoCount(userInputMoneyDto.getUserLottoTicketCount());
		return userInputMoneyDto;
	}

	private UserLottoDto activateLottoMachine(UserInputMoneyDto userInputMoneyDto) {
		UserLottoDto userLottoDto = lottoService.makeRandomLottoNumber(userInputMoneyDto.getUserLottoTicketCount());
		outputView.printUserLotto(userLottoDto.getUserLottos());
		return userLottoDto;
	}

	private WinningNumberDto enterWinningNumber() {
		WinningNumberDto winningNumberDto = inputController.getWinningNumber();
		inputController.getBonusNumber(winningNumberDto);
		return winningNumberDto;
	}

	private void activateRankStatisticsService(UserInputMoneyDto userInputMoneyDto, UserLottoDto userLottoDto,
		WinningNumberDto winningNumberDto) {
		StatisticsDto statisticsDto = statisticsService.updateStatistics(userLottoDto, winningNumberDto,
			userInputMoneyDto.getInputPrice());
		outputView.printUserStatistics(statisticsDto);
	}

}
