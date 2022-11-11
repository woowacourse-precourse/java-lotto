package lotto;

import java.util.ArrayList;
import java.util.Collections;
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
		createLotto(lottoCount);

		View.showLottoPurchasedGuideMessage(lottoCount);
		View.showLottoNumbers(lottoList);

		View.showWinningNumberInputGuideMessage();
		userInput = Input.userInput();
		Checker.checkWinningNumberInput(userInput);

		View.showBonusNumberInputGuideMessage();
		userInput = Input.userInput();
		Checker.checkBonusNumberInput(userInput);

		MakeWinner.compareNumbers(Checker.winningNumber,Checker.bonusNumber);
	}

	public void createLotto(int lottoCount) {
		while (lottoCount > 0) {
			List<Integer> lottoNumbers = createLottoNumbers();
			Collections.sort(lottoNumbers);

			if (!lottoList.contains(lottoNumbers)) {
				lottoList.add(new Lotto(lottoNumbers));
				lottoCount--;
			}
		}
	}

	private List<Integer> createLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}

	public static List<Lotto> getLottoList() {
		return lottoList;
	}
}
