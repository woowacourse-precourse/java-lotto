package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	InputView inputView = new InputView();

	public void run() {
		chargeLottoPurchaseAmount();
		receiveWinningNumbers();
	}

	public void chargeLottoPurchaseAmount() {
		String userInput = inputView.inputUserMoney();
		inputView.validMoney(userInput);
		int userMoney = Integer.parseInt(userInput);
		int ticketNumber = userMoney / 1000;
		LottoTicket lottoTicket = new LottoTicket(ticketNumber);
		List<List<Integer>> lottoTickets = lottoTicket.createLottoTickets();
		OutputView.printLottoNumber(ticketNumber);
		OutputView.printLottoTickets(lottoTickets);
	}

	public void receiveWinningNumbers() {
		String userInput = inputView.inputWinningNumber();
		inputView.validWinningNumber(userInput);
	}

	public void receiveBonusNumber() {
		String userInput = inputView.inputBonusNumber();
		inputView.validBonusNumber(userInput);
	}
}
