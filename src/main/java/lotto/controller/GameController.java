package lotto.controller;

import lotto.domain.lotto.LottoMachine;
import lotto.domain.player.BonusNumber;
import lotto.domain.player.Player;
import lotto.domain.player.PurchaseAmount;
import lotto.domain.player.PurchaseCount;
import lotto.domain.player.WinningNumber;
import lotto.domain.result.Result;

import static lotto.ui.ConsoleOutput.*;

public class GameController {

	public void run() {
		try {
			Player player = new Player();
			PurchaseAmount purchaseAmount = PurchaseAmount.from(player.receivePurchaseAmount());
			PurchaseCount purchaseCount = PurchaseCount.from(purchaseAmount);

			LottoMachine lottoMachine = new LottoMachine();
			lottoMachine.issueLotto(purchaseCount);

			WinningNumber winningNumber = WinningNumber.from(player.receiveWinningNumber());
			BonusNumber bonusNumber = BonusNumber.from(player.receiveBonusNumber(), winningNumber);

			Result result = new Result(winningNumber, bonusNumber);
			result.calculateLottoRank();
			result.calculateTotalProfit(purchaseAmount);
		} catch (IllegalArgumentException e) {
			PrintExitMessage();
		}
	}
}
