package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoProgram {
	private static final int PRICE = 1000;
	private static List<Lotto> lottoList = new ArrayList<>();

	public void start() {
		View.showPurchaseInputGuideMessage();
		String userInput = Input.userInput();
		Checker.checkUserInput(userInput);

		int lottoCount = Integer.parseInt(userInput) / PRICE;
		View.showLottoPurchasedGuideMessage(lottoCount);
	}

	private List<Integer> createLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(1, 9, 6);
	}
}
