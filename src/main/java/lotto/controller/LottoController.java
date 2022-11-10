package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;
import lotto.view.InputView;

public class LottoController {

	public void run() {
		chargeLottoPurchaseAmount();
	}

	public void chargeLottoPurchaseAmount() {
		InputView inputView = new InputView();
		String userNumber = inputView.inputUserMoney();
		inputView.validCheck(userNumber);
		List<List<Integer>> lottoTickets = new ArrayList<>();
		LottoTicket lottoTicket = new LottoTicket(Integer.parseInt(userNumber));
		lottoTickets = lottoTicket.createLottoTickets();

	}
}
