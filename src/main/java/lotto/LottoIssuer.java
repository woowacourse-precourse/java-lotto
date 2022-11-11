package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.ui.ConsoleOutput.*;

public class LottoIssuer {

	private static int purchasedLotto;
	public static List<List<Integer>> issuedLottoes = new ArrayList<List<Integer>>();

	public LottoIssuer(long totalAmount) {
		countLotto(totalAmount);
		issueLotto();
	}

	private void countLotto(long totalAmount) {
		int purchasedLotto = Math.toIntExact(totalAmount) / Setup.LOTTO_PRICE.getValue();
		PrintNotificationMessage(purchasedLotto);
		this.purchasedLotto = purchasedLotto;
	}

	private static void issueLotto() {
		for (int i = 0; i < purchasedLotto; i++) {
			Lotto lotto = new Lotto(generateLottoNumbers());
			issuedLottoes.add(lotto.getNumbers());
		}
	}

	private static List<Integer> generateLottoNumbers() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		return numbers;
	}
}
