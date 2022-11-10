package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void run() {
		chargeLottoPurchaseAmount();
	}

	public void chargeLottoPurchaseAmount() {
		InputView inputView = new InputView();
		String userInput = inputView.inputUserMoney();
		inputView.validCheck(userInput);
		int userMoney = Integer.parseInt(userInput);
		int ticketNumber = userMoney / 1000;
		LottoTicket lottoTicket = new LottoTicket(ticketNumber);
		List<List<Integer>> lottoTickets = lottoTicket.createLottoTickets();
		OutputView.printLottoNumber(ticketNumber);
		OutputView.printLottoTickets(lottoTickets);
	}
}
