package lotto;

import lotto.domain.LottoShop;
import lotto.domain.Purchaser;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.io.Input;
import lotto.io.Output;

public class Application {
	public static void main(String[] args) {
		try {
			Purchaser purchaser = new Purchaser(Input.requestInputMoney());
			Output.printNumberOfPurchaseLotto(purchaser.getNumberOfPurchaseLotto());
			LottoShop lottoShop = new LottoShop(purchaser.getNumberOfPurchaseLotto());
			Output.printLottos(lottoShop.getLottos());
			WinningNumber winningNumber = new WinningNumber(Input.requestInputWinningNumber(), Input.requestInputBonusNumber());
			WinningResult winningResult = new WinningResult(lottoShop.getLottos(), winningNumber, purchaser);
			Output.printRank(winningResult.getResult());
			Output.printProfit(winningResult.getRateOfProfit());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
