package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchasingAmount;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	int numberOfTickets;
	List<Lotto> lotteries;
	WinningNumbers winningNumbers;

	public void control() {
		calculateNumberOfTickets();
		issueLotteries();
		receiveWinningNumbers();
	}

	void calculateNumberOfTickets() {
		PurchasingAmount purchasingAmount = new PurchasingAmount(Integer.parseInt(inputView.getPurchasingAmount()));
		numberOfTickets = purchasingAmount.getNumberOfTickets();
		outputView.printNumberOfTickets(numberOfTickets);
	}

	void issueLotteries() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		lotteries = new ArrayList<>();
		while (lotteries.size() != numberOfTickets) {
			lotteries.add(new Lotto(lottoGenerator.getNumbers()));
		}
		lotteries.forEach(lotto -> System.out.println(lotto.getNumbers()));
	}

	void receiveWinningNumbers() {
		winningNumbers = new WinningNumbers(inputView.getWinningNumbers());
	}

	List<Lotto> getLotteries() {
		return lotteries;
	}
}
