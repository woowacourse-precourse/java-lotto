package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;

public class MakeWinner {
	private static final String FIRST_PRIZE = "2,000,000,000";
	private static final String SECOND_PRIZE = "30,000,000";
	private static final String THIRD_PRIZE = "1,500,000";
	private static final String FOURTH_PRIZE = "50,000";
	private static final String FIFTH_PRIZE = "5,000";
	private static final String FIRST_MATCH_NUMBER = "6";
	private static final String SECOND_MATCH_NUMBER = "5";
	private static final String THIRD_MATCH_NUMBER = "5";
	private static final String FOURTH_MATCH_NUMBER = "4";
	private static final String FIFTH_MATCH_NUMBER = "3";
	private static final String MATCH_BONUS = "matchBonusNumber";
	private static final String NOT_MATCH_BONUS = "notMatchBonusNumber";
	private static List<List<String>> winnerPrize;
	private static List<List<Integer>> winner;
	//숫자 몇 개 맞췄는지, bonusNumber포함인지를 저장. bonusNumber맞췄으면 1, 못맞췄으면 -1 저장

	public static void initWinnerPrize() {
		winnerPrize = new ArrayList<>();
		winner = new ArrayList<>();

		winnerPrize.add(List.of(FIRST_MATCH_NUMBER, NOT_MATCH_BONUS, FIRST_PRIZE));
		winnerPrize.add(List.of(SECOND_MATCH_NUMBER, MATCH_BONUS, SECOND_PRIZE));
		winnerPrize.add(List.of(THIRD_MATCH_NUMBER, NOT_MATCH_BONUS, THIRD_PRIZE));
		winnerPrize.add(List.of(FOURTH_MATCH_NUMBER, NOT_MATCH_BONUS, FOURTH_PRIZE));
		winnerPrize.add(List.of(FIFTH_MATCH_NUMBER, NOT_MATCH_BONUS, FIFTH_PRIZE));
	}

	public static void compareNumbers(List<String> winningNumber, List<String> bonusNumber) {
		initWinnerPrize();
		List<Lotto> lottos = LottoProgram.getLottoList();

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
		return matchResult.get(0) >= 3;
	}

	private static List<Integer> calculateMatchNumberCount(List<String> winningNumber, List<Integer> numbers,
		List<String> bonusNumber) {
		int matchNumberCount = 0;

		for (String number : winningNumber) {
			if (numbers.contains(Integer.parseInt(number))) {
				matchNumberCount++;
			}
		}

		if (numbers.contains(Integer.parseInt(bonusNumber.get(0)))) {
			matchNumberCount++;
			return new ArrayList<>(List.of(matchNumberCount, 1));
		}

		return new ArrayList<>(List.of(matchNumberCount, -1));
	}

}
