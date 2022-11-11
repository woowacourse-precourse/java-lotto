package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoProgram {
	private static final int PRICE = 1000;
	private static int lottoCount;
	private static List<Lotto> lottoList = new ArrayList<>();

	public void start() {
		View.showPurchaseInputGuideMessage();
		String userInput = Input.userInput();
		Checker.checkUserInput(userInput);

		lottoCount = Integer.parseInt(userInput) / PRICE;
		createLotto(lottoCount);

		View.showLottoPurchasedGuideMessage(lottoCount);
		View.showLottoNumbers(lottoList);

		View.showWinningNumberInputGuideMessage();
		userInput = Input.userInput();
		Checker.checkWinningNumberInput(userInput);

		View.showBonusNumberInputGuideMessage();
		userInput = Input.userInput();
		Checker.checkBonusNumberInput(userInput);

		MakeWinner.compareNumbers(Checker.winningNumber, Checker.bonusNumber,lottoList);
		MakeWinner.createWinnerResult();

		View.showWinnings();

		View.showYield(calculateYield());

	}

	public void createLotto(int lottoCount) {
		while (lottoCount > 0) {
			List<Integer> lottoNumbers = createLottoNumbers();
			Set<Integer> hashSet = new TreeSet<>(Set.copyOf(lottoNumbers));

			if (!lottoList.contains(lottoNumbers)) {
				lottoList.add(new Lotto(hashSet));
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

	public static String calculateYield(){
		double totalPrice = lottoCount*1000;
		double totalPrize = MakeWinner.calculateTotalPrize();


		return String.format("%.1f",(totalPrize/totalPrice)*100.0);

	}
}
