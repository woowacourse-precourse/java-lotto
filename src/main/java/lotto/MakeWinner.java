package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;

public class MakeWinner {
	private static final int MATCH_COUNT_INDEX = 0;
	private static final int MIN_WINNER_MATCH_NUMBER = 3;
	private static final int MATCH_BONUS_NUMBER = 1;
	private static final int NOT_MATCH_BONUS_NUMBER = -1;
	private static final int BONUS_NUMBER_INDEX = 1;
	private static final int INIT = 0;
	private static List<List<Integer>> winner;
	//(숫자 몇 개 맞췄는지),(bonusNumber맞췄으면 1, 못맞췄으면 -1) 저장
	public static int[] winnerResult;

	public static void initWinnerPrize() {
		winner = new ArrayList<>();
		winnerResult = new int[8];
	}

	public static void compareNumbers(List<String> winningNumber, List<String> bonusNumber, List<Lotto> lottos) {
		initWinnerPrize();

		for (Lotto lotto : lottos) {
			List<Integer> matchResult = calculateMatchNumberCount(winningNumber, lotto.getNumbers(), bonusNumber);

			addWinner(matchResult);
		}

	}

	private static void addWinner(List<Integer> matchResult) {
		if (isWinner(matchResult)) {
			winner.add(matchResult);
		}
	}

	private static boolean isWinner(List<Integer> matchResult) {
		return matchResult.get(MATCH_COUNT_INDEX) >= MIN_WINNER_MATCH_NUMBER;
	}

	private static List<Integer> calculateMatchNumberCount(List<String> winningNumber, List<Integer> numbers,
		List<String> bonusNumber) {
		int matchNumberCount = INIT;

		for (String number : winningNumber) {
			if (numbers.contains(Integer.parseInt(number))) {
				matchNumberCount++;
			}
		}

		if (matchNumberCount == 5 && numbers.contains(Integer.parseInt(bonusNumber.get(MATCH_COUNT_INDEX)))) {
			return new ArrayList<>(List.of(matchNumberCount, MATCH_BONUS_NUMBER));
		}

		return new ArrayList<>(List.of(matchNumberCount, NOT_MATCH_BONUS_NUMBER));
	}

	public static void createWinnerResult() {
		for (List<Integer> list : winner) {
			int matchCount = list.get(MATCH_COUNT_INDEX);

			if (matchCount == 6 && list.get(BONUS_NUMBER_INDEX) == NOT_MATCH_BONUS_NUMBER) {
				winnerResult[7]++;
				continue;
			}

			if (matchCount == 5 && list.get(BONUS_NUMBER_INDEX) == MATCH_BONUS_NUMBER) {
				winnerResult[6]++;
				continue;
			}

			winnerResult[matchCount]++;

		}

	}

}
