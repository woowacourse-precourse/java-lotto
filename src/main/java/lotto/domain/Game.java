package lotto.domain;

import lotto.LottoIssuer;
import lotto.domain.player.BonusNumber;
import lotto.domain.player.Player;
import lotto.domain.player.PurchaseAmount;
import lotto.domain.player.WinningNumber;
import lotto.domain.result.Result;

import java.util.List;

public class Game {

	public void run() {
		Player player = new Player();
		long purchaseAmount = new PurchaseAmount(player.receivePurchaseAmount()).toConvert();
		int purchaseCount = new PurchaseCounter().countLotto(purchaseAmount);

		new LottoIssuer(purchaseCount);

		List<Integer> winningNumber = new WinningNumber(player.receiveWinningNumber()).toConvert();
		int bonusNumber = new BonusNumber(player.receiveBonusNumber(), winningNumber).toConvert();

		Result result = new Result(winningNumber, bonusNumber);
		result.calculateLottoRank();
		result.calculateTotalProfit(purchaseAmount);
	}
}
