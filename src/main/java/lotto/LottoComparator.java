package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;

public class LottoComparator {
	private static final int MIN_WINNER_MATCH_COUNT = 3;
	private static final int FIRST_WINNER_MATCH_COUNT = 6;
	private static final int SECOND_WINNER_MATCH_COUNT = 5;
	private static final int INIT = 0;
	private static List<Lotto> winner;

	public static void initWinnerAndPrize() {
		winner = new ArrayList<>();
	}

	public static void compareNumbers(List<Lotto> lottos) {
		initWinnerAndPrize();

		for (Lotto lotto : lottos) {
			int countMatchNumber = calculateCountMatchNumber(lotto, INIT, WinningLotto.getWinningNumber(),
				WinningLotto.getBonusNumber().get(0));
			lotto.setCountMatchNumber(countMatchNumber);

			addWinner(lotto);
		}

	}

	public static void addWinner(Lotto lotto) {
		if (isWinner(lotto)) {
			winner.add(lotto);
		}
	}

	public static boolean isWinner(Lotto lotto) {
		return lotto.getCountMatchNumber() >= MIN_WINNER_MATCH_COUNT;
	}

	public static int calculateCountMatchNumber(Lotto lotto, int countMatchNumber, List<String> winningNumber,
		String bonusNumber) {
		Set<Integer> numbers = lotto.getNumbers();

		for (String number : winningNumber) {
			if (isContainsNumber(numbers, number)) {
				countMatchNumber++;
			}
		}

		checkMatchBonusNumber(lotto, bonusNumber, countMatchNumber);

		return countMatchNumber;
	}

	public static void checkMatchBonusNumber(Lotto lotto, String bonusNumber, int matchNumberCount) {
		if (matchNumberCount == SECOND_WINNER_MATCH_COUNT && isContainsNumber(lotto.getNumbers(), bonusNumber)) {
			lotto.setMatchBonusNumber(true);
		}
	}

	public static boolean isContainsNumber(Set<Integer> numbers, String number) {
		return numbers.contains(Integer.parseInt(number));
	}

	public static void calculatePrizeCount() {

		for (Lotto lotto : winner) {
			int matchCount = lotto.getCountMatchNumber();

			boolean isFirstWinner = checkFirstWinner(lotto, matchCount);
			boolean isSecondWinner = checkSecondWinner(lotto, matchCount);

			if (!isFirstWinner && !isSecondWinner) {
				for (Prize prize : Prize.values()) {
					if (matchCount == prize.getMatchCount()) {
						prize.enhancePrizeCount();
					}
				}
			}
		}

	}

	private static boolean checkSecondWinner(Lotto lotto, int matchCount) {

		if (isSecondWinner(lotto, matchCount)) {
			Prize.SECOND_PRIZE.enhancePrizeCount();

			return true;
		}

		return false;
	}

	private static boolean checkFirstWinner(Lotto lotto, int matchCount) {

		if (isFirstWinner(lotto, matchCount)) {
			Prize.FIRST_PRIZE.enhancePrizeCount();

			return true;
		}

		return false;
	}

	public static boolean isSecondWinner(Lotto lotto, int matchCount) {
		return matchCount == SECOND_WINNER_MATCH_COUNT && lotto.getIsMatchBonusNumber();
	}

	public static boolean isFirstWinner(Lotto lotto, int matchCount) {
		return matchCount == FIRST_WINNER_MATCH_COUNT && !lotto.getIsMatchBonusNumber();
	}

	public static int calculateTotalPrize() {
		int totalPrize = INIT;

		for (Prize prize : Prize.values()) {
			totalPrize += prize.getPrize() * prize.getPrizeCount();
		}

		return totalPrize;
	}
}
