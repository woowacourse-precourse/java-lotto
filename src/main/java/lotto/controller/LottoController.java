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
			LottoStore lottoStore = new LottoStore(InputView.scanPurchaseAmount());
			List<Lotto> lottoTickets = buyLottoTickets(lottoStore.getNumberOfTickets());
			WinningNumbers winningNumbers = new WinningNumbers(InputView.scanWinningNumbers(),
				InputView.scanBonusNumber());
			calculateResult(lottoStore.getPurchaseAmount(), lottoTickets, winningNumbers);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private List<Lotto> buyLottoTickets(int numberOfTickets) {
		LottoMachine lottoMachine = new LottoMachine(numberOfTickets);
		OutputView.printNumberOfTickets(numberOfTickets);
		OutputView.printLottoTickets(lottoMachine);
		return lottoMachine.getLottoTickets();
	}

	private void calculateResult(int purchaseAmount, List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
		RankCounter rankCounter = new RankCounter(lottoTickets, winningNumbers);
		ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(rankCounter.getRanks(), purchaseAmount);
		OutputView.printWinningResult(rankCounter.getRanks());
		OutputView.printProfitRate(profitRateCalculator.getProfitRate());
	}
}
