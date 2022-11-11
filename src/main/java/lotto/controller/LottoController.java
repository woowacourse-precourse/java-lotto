package lotto.controller;

import java.util.List;

import lotto.repository.dto.UserLottoDto;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.util.InputUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	private final LottoService lottoService;
	private final StatisticsService statisticsService;
	private final OutputView outputView;
	private final InputView inputView;
	private final InputUtil inputUtil;

	public LottoController(LottoService lottoService, OutputView outputView,
		InputView inputView, StatisticsService statisticsService, InputUtil inputUtil) {
		this.lottoService = lottoService;
		this.outputView = outputView;
		this.inputView = inputView;
		this.statisticsService = statisticsService;
		this.inputUtil = inputUtil;
	}

	public void startApplication() {

		String userMoney = inputView.printStart();
		Integer userMoneyNumber;
		try {
			userMoneyNumber = inputUtil.validateUserMoney(userMoney);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return;
		}

		int lottoCount = userMoneyNumber / 1000;
		outputView.printLottoCount(lottoCount);
		UserLottoDto userLottoDto = lottoService.makeRandomLottoNumber(lottoCount);
		outputView.printUserLotto(userLottoDto.getUserLotto());
		String answer = inputView.printWinnerNumber();

		List<Integer> answerNumber;
		Integer bonusNumber;
		try {
			answerNumber = inputUtil.validAnswer(answer);
			String bonus = inputView.bonusNumber();
			bonusNumber = inputUtil.validateBonus(bonus);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return;
		}

		statisticsService.updateStatistics(userLottoDto, answerNumber, bonusNumber);
		outputView.printUserStatistics(userMoneyNumber);

	}

}
