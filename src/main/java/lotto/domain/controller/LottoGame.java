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
	private CompareNumber compareNumber;
	public LottoTicket lottoTicket;

	public void start() {
		try {
			buyTicket();
			getWinningNumber();
			getBonusNumber();
			getScore();
			getRateOfReturn();
		} catch (ExceptionHandler exceptionHandler) {
			System.out.println(exceptionHandler.getMessage());
		}
	}

	private void buyTicket() {
		print.message(Message.START);
		pay = new Pay(readLine());
		Store store = new Store(pay.getPay());
		lottoTicket = new LottoTicket(store.issueLottoTicket());
		print.LottoTicket(store.count, lottoTicket.getLottoTicket());
	}

	private void getWinningNumber() {
		print.message(Message.WINNING_NUMBER);
		winningNumber = new WinningNumber(readLine());
	}

	private void getBonusNumber() {
		print.message(Message.BONUS_NUMBER);
		bonusBall = new BonusBall(readLine(), winningNumber.getWinningNumbers());
	}

	private void getScore() {
		compareNumber = new CompareNumber(winningNumber, bonusBall, lottoTicket);
		print.result(compareNumber.result);
	}

	private void getRateOfReturn() {
		RateOfReturn rateOfReturn = new RateOfReturn(pay.getPay(), compareNumber.result);
		System.out.printf(Message.RESULT_RATE.getMessage(), rateOfReturn.rateOfReturn);
	}
}
