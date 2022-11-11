package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoComparator {
	private static final int MIN_WINNER_MATCH_NUMBER = 3;
	private static final int FIFTH_PRIZE = 5000;
	private static final int FOURTH_PRIZE = 50000;
	private static final int THIRD_PRIZE = 1500000;
	private static final int SECOND_PRIZE = 30000000;
	private static final int FIRST_PRIZE = 2000000000;
	private static final int INIT = 0;
	private static final int INIT_PRIZE_COUNT_SIZE = 5;
	private static List<Lotto> winner;
	public static List<Integer> prizeCount;
	// 0: 5등, 1: 4등, 2: 3등, 3: 2등, 4: 1등
	public static List<Integer> prize;
	// 0: 5등, 1: 4등, 2: 3등, 3: 2등, 4: 1등
	public static int totalPrize;

	public static void initWinnerAndPrize() {
		winner = new ArrayList<>();
		prizeCount = new ArrayList<>(Collections.nCopies(INIT_PRIZE_COUNT_SIZE, INIT));

		totalPrize = 0;
		prize = new ArrayList<>(List.of(FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE));

	}

	public static void compareNumbers(List<Lotto> lottos) {
		initWinnerAndPrize();

		for (Lotto lotto : lottos) {
			int matchNumberCount = calculateMatchNumberCount(lotto);
			lotto.setMatchNumberCount(matchNumberCount);

			addWinner(lotto);
		}

	}

	private static void addWinner(Lotto lotto) {
		if (isWinner(lotto)) {
			winner.add(lotto);
		}
	}

	private static boolean isWinner(Lotto lotto) {
		return lotto.matchNumberCount >= MIN_WINNER_MATCH_NUMBER;
	}

	private static int calculateMatchNumberCount(Lotto lotto) {
		Set<Integer> numbers = lotto.getNumbers();
		List<String> winningNumber = WinningLotto.getWinningNumber();
		String bonusNumber = WinningLotto.getBonusNumber().get(0);

		int matchNumberCount = INIT;

		for (String number : winningNumber) {
			if (numbers.contains(Integer.parseInt(number))) {
				matchNumberCount++;
			}
		}

		if (matchNumberCount == 5 && numbers.contains(Integer.parseInt(bonusNumber))) {
			lotto.setMatchBonusNumber(true);
		}

		return matchNumberCount;
	}

	public static void createWinnerResult() {

		for (Lotto lotto : winner) {
			int matchCount = lotto.matchNumberCount;

			if (matchCount == 6 && !lotto.isMatchBonusNumber) {
				prizeCount.set(4, prizeCount.get(4) + 1);
				continue;
			}

			if (matchCount == 5 && lotto.isMatchBonusNumber) {
				prizeCount.set(3, prizeCount.get(3) + 1);
				continue;
			}

			// 0 : 5등, 1: 4등, 2: 3등, 3:2등, 4:1등
			int index = matchCount - 3;
			prizeCount.set(index, prizeCount.get(index) + 1);
		}

	}

	public static int calculateTotalPrize() {
		int totalPrize = 0;

		for (int index = 0; index < prizeCount.size(); index++) {
			totalPrize += prize.get(index) * prizeCount.get(index);
		}

		return totalPrize;
	}
}
