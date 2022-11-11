package lotto.controller;

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
		Integer userMoneyNumber = inputUtil.validateUserMoney(userMoney);
		int lottoCount = userMoneyNumber / 1000;
		outputView.printLottoCount(lottoCount);
		UserLottoDto userLottoDto = lottoService.makeRandomLottoNumber(lottoCount);
		outputView.printUserLotto(userLottoDto.getUserLotto());

	}

}
