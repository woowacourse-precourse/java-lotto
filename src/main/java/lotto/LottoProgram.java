package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.checker.Checker;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.view.View;

public class LottoProgram {
	private static final int PRICE_UNIT = 1000;
	private static final int MIN_LOTTO_UNIT = 1;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final double YIELD_UNIT = 100.0;
	private static int lottoCount;
	private static List<Lotto> lottoList;

	LottoProgram() {
		lottoCount = 0;
		lottoList = new ArrayList<>();
	}

	public void start() {
		try {
			buyLotto();
			View.showMyLottos(lottoCount, lottoList);

			selectNumbers();
			compareWithMyLottos();

			View.showWinnings();
			View.showYield(calculateYield());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private void buyLotto() {
		payForLotto();
		createLottos(lottoCount);
	}

	private void selectNumbers() {
		selectWinningNumbers();
		selectBonusNumbers();
	}

	private static void compareWithMyLottos() {
		initMatchCount();
		LottoComparator.compareNumbers(lottoList);
		LottoComparator.createWinnerResult();
	}

	private static void initMatchCount() {
		for (Prize prize : Prize.values()) {
			prize.initPrizeCount();
		}
	}

	private static void selectBonusNumbers() {
		View.showBonusNumberInputGuideMessage();
		String userInput = Input.userInput();

		WinningLotto.createBonusNumber(userInput);
		Checker.checkBonusNumberInput(WinningLotto.getBonusNumber());
	}

	private static void selectWinningNumbers() {
		View.showWinningNumberInputGuideMessage();
		String userInput = Input.userInput();

		WinningLotto.createWinningNumber(userInput);
		Checker.checkWinningNumberInput(WinningLotto.getWinningNumber());
	}

	private void payForLotto() {
		View.showPurchaseInputGuideMessage();
		String userInput = Input.userInput();
		Checker.checkPriceException(userInput);

		lottoCount = Integer.parseInt(userInput) / PRICE_UNIT;
	}

	public void createLottos(int lottoCount) {

		while (lottoCount >= MIN_LOTTO_UNIT) {
			List<Integer> lottoNumbers = createLottoNumbers();
			Set<Integer> hashSet = new TreeSet<>(Set.copyOf(lottoNumbers));

			if (!lottoList.contains(lottoNumbers)) {
				lottoList.add(new Lotto(hashSet));
				lottoCount--;
			}

		}

	}

	private List<Integer> createLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
	}

	public static List<Lotto> getLottoList() {
		return lottoList;
	}

	public static String calculateYield() {
		double totalPrice = lottoCount * PRICE_UNIT;
		double totalPrize = LottoComparator.calculateTotalPrize();

		return String.format("%.1f", (totalPrize / totalPrice) * YIELD_UNIT);
	}
}
