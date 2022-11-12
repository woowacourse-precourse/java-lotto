package lotto.domain;

import lotto.Calculation;
import lotto.LottoIssuer;
import lotto.domain.player.BonusNumber;
import lotto.domain.player.Player;
import lotto.domain.player.PurchaseAmount;
import lotto.domain.player.WinningNumber;

import java.util.List;

public class Game {

	public void run() {
		Player player = new Player();
		long purchaseAmount = new PurchaseAmount(player.receivePurchaseAmount()).toConvert();
		int purchaseCount = new PurchaseCounter().countLotto(purchaseAmount);

		LottoIssuer lottoIssuer = new LottoIssuer(purchaseCount);

		List<Integer> winningNumber = new WinningNumber(player.receiveWinningNumber()).toConvert();
		List<Integer> bonusNumber = new BonusNumber(player.receiveBonusNumber(), winningNumber).toConvert();

		Calculation.findMatch();
		Calculation.calculateResult();
		Calculation.calculateProfit(purchaseAmount);
	}
}
