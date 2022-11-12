package lotto.controller;

import lotto.domain.lotteryseller.LotterySeller;
import lotto.domain.lotterystore.LotteryStoreUi;
import lotto.dto.lotteryseller.RandomNumbersSets;
import lotto.dto.lotterystore.MoneyForPurchase;
import lotto.dto.lotterystore.NumbersForWinningPrize;

public class LotteryRequestController {
	private static final LotteryRequestController controller = new LotteryRequestController();
	private final LotteryStoreUi lotteryStoreUi;
	private final LotterySeller lotterySeller;
	private final LottoCommittee lottoCommittee;


	private LotteryRequestController() {
		lotteryStoreUi = LotteryStoreUi.getStoreUi();
		lotterySeller = LotterySeller.getLotterySeller();
		lottoCommittee = LotteryCommittee.getLotteryCommittee();
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

	public void receiveRandomNumbersSets(RandomNumbersSets randomNumbersSetsDto) {
		sendRandomNumbersSetsToLotteryCommittee(randomNumbersSetsDto);
		sendRandomNumbersSetsToLotteryStoreUi(randomNumbersSetsDto);
	}

	public void sendRandomNumbersSetsToLotteryStoreUi(RandomNumbersSets randomNumbersSetsDto) {
		lotteryStoreUi.printRandomNumberSets(randomNumbersSetsDto);
	}

	private void sendRandomNumbersSetsToLotteryCommittee(RandomNumbersSets randomNumbersSetsDto) {
		lottoCommittee.receiveRandomNumbersSets(randomNumbersSetsDto);
	}
}
