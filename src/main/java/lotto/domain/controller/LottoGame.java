package lotto.domain.controller;

import lotto.domain.model.*;
import lotto.domain.view.Message;
import lotto.domain.view.Print;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGame {
	final private Print print = new Print();
	private WinningNumber winningNumber;
	private BonusBall bonusBall;
	private Pay pay;
	private Store store;
	private CompareNumber compareNumber;

	public void start() {
		buyTicket();
		getWinningNumber();
		getBonusNumber();
		getScore();
		getRateOfReturn();
	}

	private void buyTicket() {
		print.message(Message.START);
		pay = new Pay(readLine());
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

	private void getScore() {
		compareNumber = new CompareNumber(winningNumber, bonusBall, store.lottoTicket);
		print.result(compareNumber.result);
	}

	private void getRateOfReturn() {
		RateOfReturn rateOfReturn = new RateOfReturn(pay.getPay(), compareNumber.result);
		System.out.printf(Message.RESULT_RATE.getMessage(), rateOfReturn.rateOfReturn);
	}


}
