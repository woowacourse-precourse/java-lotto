package lotto.domain;

import lotto.view.LottoTicketView;
import lotto.view.StatisticsView;

public class LottoMachine {
	private static Money money;
	private static LottoTicket lottoTicket;
	private static WinningNumbers winningNumbers;
	private static BonusNumber bonusNumber;

	public static void start() {
		try {
			buyTicket();
			getResultOfWinning();
		} catch (IllegalArgumentException error) {
			System.out.println(error);
			return;
		}
	}

	private static void buyTicket() {
		money = new Money(Input.getPurchaseAmount());
		lottoTicket = new LottoTicket(money.getNumberOfPurchases());
		LottoTicketView.getLottoTicketView(money.getNumberOfPurchases(), lottoTicket.getTicket());
		winningNumbers = new WinningNumbers(Input.getWinningNumber());
		bonusNumber = new BonusNumber(Input.getBonusNumber(), winningNumbers.getNumbers());
	}

	private static void getResultOfWinning() {
		Checker checker = new Checker(lottoTicket.getTicket(), winningNumbers.getNumbers(), bonusNumber.getNumber());
		Earning earning = new Earning(money.getMoney(), checker.getTotalCashPrize());
		StatisticsView.getStatisticsView(checker.getWinGames(), earning.getEarningRate());
	}
}
