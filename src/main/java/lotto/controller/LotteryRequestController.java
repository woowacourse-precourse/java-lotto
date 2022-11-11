package lotto.controller;

import lotto.dto.lotterystore.MoneyForPurchase;
import lotto.dto.lotterystore.NumbersForWinningPrize;

public class LotteryRequestController {
	private static final LotteryRequestController controller = new LotteryRequestController();

	private LotteryRequestController() {
	}

	public static LotteryRequestController getController() {
		return controller;
	}

	public void receiveMoneyForPurchase(MoneyForPurchase moneyDto) {
		sendMoneyForPurchase(moneyDto);
	}

	private void sendMoneyForPurchase(MoneyForPurchase moneyDto) {

	}

	public void receiveNumbersForWinningPrize(NumbersForWinningPrize winningNumbersDto) {

	}
}
