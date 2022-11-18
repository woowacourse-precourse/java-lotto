package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

public class LottoService {

	public static void setMoney(String userInput) {
		Money.from(userInput);
	}

	public static int purchasedLottoAmount() {
		return Money.getPurchaseAmount() / 1000;
	}

	public static void createUserLottos(int purchasedLottoCount) {
		Lottos.createUserLottos(purchasedLottoCount);
	}

	public static void createWinningLotto(String winningLottoString) {
		WinningLotto.createWinningLotto(winningLottoString);
	}

	public static void createBonusNumber(String bonusNumber) {
		WinningLotto.createBonusNumber(bonusNumber);
	}

	public static void calculateStatistics() {
		List<Lotto> userLottos = Lottos.getLottos();
		List<Integer> winningLotto = WinningLotto.getWinningLotto();
		int bonusNumber = WinningLotto.getBonusNumber();

		Result.calculateStatistics(userLottos, winningLotto, bonusNumber);
	}

	public static void calculateProfitRate(int purchaseAmount) {
		Result.calculateProfitRate(purchaseAmount);
	}
}
