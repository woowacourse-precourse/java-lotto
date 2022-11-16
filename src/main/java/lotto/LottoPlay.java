package lotto;

import lotto.controller.LotteryRequestController;
import lotto.domain.lotteryseller.LotterySeller;
import lotto.domain.lotteryserver.LotteryServer;
import lotto.domain.lotterystore.LotteryStoreUi;

public class LottoPlay {
	public static void run() {
		LotteryStoreUi lotteryStoreUi = new LotteryStoreUi();
		LotteryRequestController requestController = new LotteryRequestController();
		LotterySeller lotterySeller = new LotterySeller();
		LotteryServer lotteryServer = new LotteryServer();

		lotteryStoreUi.takeMoneyFromBuyer(requestController);
		requestController.sendMoneyToConsumers(lotterySeller, lotteryServer);
		lotterySeller.sendGeneratedLotterySets(requestController);
		requestController.sendLottoSetsToLotteryStoreUi(lotteryStoreUi);
		requestController.sendLottoSetsToLotteryServer(lotteryServer);
		lotteryStoreUi.printMessageForLottoSets();

		lotteryStoreUi.takeWinningLotteryNumbers();
		lotteryStoreUi.takeBonusNumber(requestController, lotteryServer);
		lotteryServer.sendLottoResultMessage(requestController, lotteryStoreUi);
		lotteryStoreUi.printResultMessage();
	}
}
