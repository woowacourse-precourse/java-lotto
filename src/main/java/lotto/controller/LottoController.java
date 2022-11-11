package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.ProfitRateCalculator;
import lotto.domain.RankCounter;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void play() {
		LottoStore lottoStore = new LottoStore(InputView.scanPurchaseAmount());
		int numberOfTickets = lottoStore.getNumberOfTickets();
		LottoMachine lottoMachine = new LottoMachine(numberOfTickets);
		OutputView.printNumberOfTickets(numberOfTickets);
		OutputView.printLottoTickets(lottoMachine);
		WinningNumbers winningNumbers = new WinningNumbers(InputView.scanWinningNumbers(), InputView.scanBonusNumber());
		RankCounter rankCounter = new RankCounter(lottoMachine.getLottoTickets(), winningNumbers);
		ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(rankCounter.getRanks(),
			lottoStore.getPurchaseAmount());
		OutputView.printWinningResult(rankCounter.getRanks());
		OutputView.printProfitRate(profitRateCalculator.getProfitRate());
	}
}
