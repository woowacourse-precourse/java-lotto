package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.Money;
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

}
