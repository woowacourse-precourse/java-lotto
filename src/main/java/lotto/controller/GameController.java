package lotto.controller;

import lotto.domain.lotto.LottoMachine;
import lotto.domain.player.PurchaseCount;
import lotto.domain.player.BonusNumber;
import lotto.domain.player.Player;
import lotto.domain.player.PurchaseAmount;
import lotto.domain.player.WinningNumber;
import lotto.domain.result.Result;

import java.util.List;

public class GameController {

	public void run() {
		Player player = new Player();
		PurchaseAmount purchaseAmount = PurchaseAmount.from(player.receivePurchaseAmount());
		PurchaseCount purchaseCount = PurchaseCount.from(purchaseAmount);

		LottoMachine lottoMachine = new LottoMachine();
		lottoMachine.issueLotto(purchaseCount);

		List<Integer> winningNumber = new WinningNumber(player.receiveWinningNumber()).toConvert();
		int bonusNumber = new BonusNumber(player.receiveBonusNumber(), winningNumber).toConvert();

		Result result = new Result(winningNumber, bonusNumber);
		result.calculateLottoRank();
		result.calculateTotalProfit(purchaseAmount);
	}
}
