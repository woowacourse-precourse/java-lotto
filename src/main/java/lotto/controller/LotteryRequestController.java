package lotto.controller;

import lotto.domain.lotteryseller.LotterySeller;
import lotto.domain.lotteryserver.LotteryServer;
import lotto.domain.lotterystore.LotteryStoreUi;
import lotto.dto.lotteryseller.LottoSetsDto;
import lotto.dto.lotterystore.MoneyDto;
import lotto.dto.lotterystore.WinningNumbersDto;

public class LotteryRequestController {
	private MoneyDto money;
	private LottoSetsDto lottoSets;

	public void receiveMoney(MoneyDto money) {
		this.money = money;
	}

	public void sendMoneyToConsumers(LotterySeller lotterySeller, LotteryServer lotteryServer) {
		lotterySeller.receiveMoney(money);
		lotteryServer.receiveMoney(money);
	}

	public void receiveLottoSets(LottoSetsDto lottoSets) {
		this.lottoSets = lottoSets;
	}

	public void sendLottoSetsToLotteryStoreUi(LotteryStoreUi lotteryStoreUi) {
		lotteryStoreUi.receiveLottoSets(lottoSets);
	}

	public void sendLottoSetsToLotteryServer(LotteryServer lotteryServer) {
		lotteryServer.receiveLottoSets(lottoSets);
	}


	public void receiveWinningNumbers(WinningNumbersDto winningNumbers,
		LotteryServer lotteryServer) {
		sendWinningNumbersToLotteryServer(winningNumbers, lotteryServer);
	}

	public void sendWinningNumbersToLotteryServer(WinningNumbersDto winningNumbers,
		LotteryServer lotteryServer) {
		lotteryServer.receiveWinningNumbers(winningNumbers);
	}

	public void receiveLottoResultMessage(String resultMessage, LotteryStoreUi lotteryStoreUi) {
		sendResultMessageToLotteryStoreUi(resultMessage, lotteryStoreUi);
	}

	private void sendResultMessageToLotteryStoreUi(String resultMessage,
		LotteryStoreUi lotteryStoreUi) {
		lotteryStoreUi.receiveResultMessage(resultMessage);
	}
}
