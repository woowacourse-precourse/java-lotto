package lotto.domain.controller;

import lotto.domain.model.*;
import lotto.domain.view.Message;
import lotto.domain.view.Print;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGame {
	final private Print print = new Print();
	WinningNumber winningNumber;
	BonusBall bonusBall;
	Store store;
	public void start() {
		buyTicket();
		getWinningNumber();
		getBonusNumber();
		CompareNumber compareNumber = new CompareNumber(winningNumber,bonusBall,store.lottoTicket);
	}

	private void buyTicket() {
		print.message(Message.START);
		Pay pay = new Pay(readLine());
		 store = new Store(pay.getPay());
		print.LottoTicket(store.count, store.lottoTicket.getLottoTicket());
	}

	private void getWinningNumber() {
		print.newLine();
		print.message(Message.WINNING_NUMBER);
		winningNumber = new WinningNumber(readLine());
	}

	private void getBonusNumber() {
		print.newLine();
		print.message(Message.BONUS_NUMBER);
		 bonusBall = new BonusBall(readLine());
	}

}
