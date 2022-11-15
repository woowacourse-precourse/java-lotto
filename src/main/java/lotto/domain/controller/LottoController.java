package lotto.domain.controller;

import lotto.domain.service.LottoService;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

public class LottoController {

	private final LottoService lottoService;

	public LottoController() {
		this.lottoService = new LottoService();
	}

	public void start() {
		int money = InputView.getPrice();
		int numberOfTickets = money / 1_000;

		OutputView.displayNumberOfTickets(numberOfTickets);
		lottoService.publishTickets(numberOfTickets);

		OutputView.displayStatistics(
			lottoService.getWinningStatistics(
				InputView.getNumbers(),
				InputView.getBonusNumber()));

		OutputView.displayIncomeRatio(
			lottoService.getTotalIncomeRatio(money)
		);
	}
}
