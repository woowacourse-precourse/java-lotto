package lotto.controller;

import java.util.List;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	private final LottoService lottoService;

	public LottoController() {
		this.lottoService = new LottoService();
	}

	public void start() {
		int money = InputView.getPrice();
		int numberOfTickets = money / 1_000;

		List<String> tickets = lottoService.publishTickets(numberOfTickets);
		OutputView.displayNumberOfTickets(numberOfTickets, tickets);

		OutputView.displayStatistics(
			lottoService.getWinningStatistics(
				InputView.getNumbers(),
				InputView.getBonusNumber()));

		OutputView.displayIncomeRatio(
			lottoService.getRateOfReturn(money)
		);
	}
}
