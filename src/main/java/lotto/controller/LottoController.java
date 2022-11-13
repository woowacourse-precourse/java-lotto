package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchasingAmount;
import lotto.domain.WinningAndBonusNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	int numberOfTickets;
	List<Lotto> lotteries;
	WinningAndBonusNumbers winningAndBonusNumbers;

	public void control() {
		calculateNumberOfTickets();
		issueLotteries();
		receiveWinningNumbers();
		receiveBonusNumbers();
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
		winningAndBonusNumbers = new WinningAndBonusNumbers(inputView.getWinningNumbers());
	}

	void receiveBonusNumbers() {
		winningAndBonusNumbers = new WinningAndBonusNumbers(Integer.parseInt(inputView.getBonusNumber()));
	}

	List<Lotto> getLotteries() {
		return lotteries;
	}
}
