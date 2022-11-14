package lotto.controller;

import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.player.BonusNumber;
import lotto.domain.player.Player;
import lotto.domain.player.PurchaseAmount;
import lotto.domain.player.PurchaseCount;
import lotto.domain.player.WinningNumber;
import lotto.domain.result.ResultProducer;

import static lotto.ui.ConsoleOutput.*;

public class GameController {

	public void run() {
		try {
			Player player = new Player();
			PurchaseAmount purchaseAmount = PurchaseAmount.from(player.receivePurchaseAmount());
			PurchaseCount purchaseCount = PurchaseCount.from(purchaseAmount);

			LottoMachine lottoMachine = new LottoMachine();
			LottoTickets lottoTickets = LottoTickets.setsOf(lottoMachine.issueLotto(purchaseCount));

			WinningNumber winningNumber = WinningNumber.from(player.receiveWinningNumber());
			BonusNumber bonusNumber = BonusNumber.from(player.receiveBonusNumber(), winningNumber);

			ResultProducer resultProducer = new ResultProducer();
			resultProducer.showResultRank(winningNumber, bonusNumber, lottoTickets);
			resultProducer.showResultProfit(purchaseAmount);
		} catch (IllegalArgumentException e) {
			PrintExitMessage();
		}
	}
}
