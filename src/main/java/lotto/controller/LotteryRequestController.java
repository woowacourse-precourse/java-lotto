package lotto.controller;

import lotto.domain.lotteryseller.LotterySeller;
import lotto.dto.lotteryseller.RandomNumbersSets;
import lotto.dto.lotterystore.MoneyForPurchase;
import lotto.dto.lotterystore.NumbersForWinningPrize;

public class LotteryRequestController {
	private static final LotteryRequestController controller = new LotteryRequestController();
	private final LotterySeller lotterySeller;

	private LotteryRequestController() {
		lotterySeller = LotterySeller.getLotterySeller();
	}

	public static LotteryRequestController getController() {
		return controller;
	}

	public void receiveMoneyForPurchase(MoneyForPurchase moneyDto) {
		sendMoneyToLotterySeller(moneyDto);
	}

	public void sendMoneyToLotterySeller(MoneyForPurchase moneyDto) {
		lotterySeller.receiveInformationAboutPurchase(moneyDto);
	}


	public void receiveNumbersForWinningPrize(NumbersForWinningPrize winningNumbersDto) {
		sendNumbersForWinningPrizeToLotto(winningNumbersDto);
	}

	public void sendNumbersForWinningPrizeToLotto(NumbersForWinningPrize winningNumbersDto) {

	}

	public void receiveRandomNumbersSets(RandomNumbersSets randomNumbersSets) {
	}
}
