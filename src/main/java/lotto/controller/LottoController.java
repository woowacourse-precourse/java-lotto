package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.ProfitRateCalculator;
import lotto.domain.RankCounter;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void play() {
		try {
			LottoStore lottoStore = receivePurchaseAmount();
			List<Lotto> lottoTickets = getLottoTickets(lottoStore.getNumberOfTickets());
			WinningNumbers winningNumbers = scanWinningNumbersAndBonusNumber();
			RankCounter scoreBoard = recordRanks(lottoTickets, winningNumbers);
			calculateProfitRate(lottoStore.getPurchaseAmount(), scoreBoard);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private LottoStore receivePurchaseAmount() {
		LottoStore lottoStore = new LottoStore(InputView.PURCHASE_AMOUNT.scanInput());
		OutputView.printNumberOfTickets(lottoStore.getNumberOfTickets());
		return lottoStore;
	}

	private List<Lotto> getLottoTickets(int numberOfTickets) {
		LottoMachine lottoTicketPrinter = new LottoMachine(numberOfTickets);
		OutputView.printLottoTickets(lottoTicketPrinter);
		return lottoTicketPrinter.getLottoTickets();
	}

	private WinningNumbers scanWinningNumbersAndBonusNumber() {
		return new WinningNumbers(InputView.WINNING_NUMBERS.scanInput(), InputView.BONUS_NUMBER.scanInput());
	}

	private RankCounter recordRanks(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
		RankCounter scoreBoard = new RankCounter(lottoTickets, winningNumbers);
		OutputView.printWinningResult(scoreBoard.getScoreBoard());
		return scoreBoard;
	}

	private void calculateProfitRate(int purchaseAmount, RankCounter scoreBoard) {
		ProfitRateCalculator calculator = new ProfitRateCalculator(scoreBoard.getScoreBoard(), purchaseAmount);
		OutputView.printProfitRate(calculator.getProfitRate());
	}
}
