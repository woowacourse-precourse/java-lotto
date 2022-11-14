package lotto.domain.controller;

import lotto.domain.model.BonusBall;
import lotto.domain.model.Pay;
import lotto.domain.model.Store;
import lotto.domain.model.WinningNumber;
import lotto.domain.view.Message;
import lotto.domain.view.Print;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGame {
	final private Print print = new Print();

	public void start() {
		buyTicket();
		getWinningNumber();
		getBonusNumber();
	}

	private void buyTicket() {
		print.message(Message.START);
		Pay pay = new Pay(readLine());
		Store store = new Store(pay.getPay());
		print.LottoTicket(store.count, store.lottoTicket.getTicket());
	}

	private void getWinningNumber() {
		print.newLine();
		print.message(Message.WINNING_NUMBER);
		WinningNumber winningNumber = new WinningNumber(readLine());
	}

	private void getBonusNumber() {
		print.newLine();
		print.message(Message.BONUS_NUMBER);
		BonusBall bonusBall = new BonusBall(readLine());
	}

}
