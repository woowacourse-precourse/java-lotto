package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ExceptionHandler;
import lotto.Ranking;
import lotto.domain.Lotto;
import lotto.view.Input;
import lotto.view.Output;

public class LottoService {
	public static List<List<Integer>> publishLotteries(int quantity) {
		List<List<Integer>> candidate = new ArrayList<>();

		for (int i = 0; i < quantity; i++) {
			Lotto lotto = new Lotto(pickLottoNumbers());

			publishLotto(candidate, lotto.getNumbers());

			Output.printPublishLotteries(candidate.get(i));
		}

		return candidate;
	}

	public static List<Integer> pickWinningNumbers() {
		String winningNumbers = Input.numbers();

		return convertStringToList(winningNumbers);
	}

	public static int pickBonusNumbers() {
		String bonusNumber = Input.numbers();

		ExceptionHandler.checkBonus(bonusNumber);

		return Integer.parseInt(bonusNumber);
	}

	public static List<Integer> getWinningRanking(List<List<Integer>> candidate, List<Integer> winningNumbers,
			int bonusNumber) {

		return countWinningNumber(candidate, winningNumbers, bonusNumber);
	}

	public static double calculateProfit(List<Integer> winningCount, double money) {
		return LottoService.getRateOfReturn(winningCount, money);
	}

	private static List<Integer> pickLottoNumbers() {
		List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

		Collections.sort(lottoNumbers);

		return lottoNumbers;
	}

	private static void publishLotto(List<List<Integer>> candidateLotto, List<Integer> candidate) {
		candidateLotto.add(candidate);
	}

	private static List<Integer> convertStringToList(String numbers) {
		List<String> lotto;

		lotto = Arrays.asList(numbers.split(","));
		ExceptionHandler.checkInput(lotto);

		return lotto.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private static List<Integer> countWinningNumber(List<List<Integer>> candidate, List<Integer> winningNumbers, int bonusNumber) {
		List<Integer> ranking = Arrays.asList(0,0,0,0,0);

		for (List<Integer> integers : candidate) {
			int count = compareNumbers(integers, winningNumbers);

			if (count >= Ranking.NUMBER_TO_CONVERT_SCORE_TO_RANK.getValue()) {
				int rank = judgement(count, checkBonus(integers, bonusNumber));

				reviseScore(ranking, rank);
			}
		}

		return ranking;
	}

	private static int judgement(int count, boolean bonus) {
		int rank = count - Ranking.NUMBER_TO_CONVERT_SCORE_TO_RANK.getValue();

		if (rank == Ranking.THIRD_PLACE.getValue()) {
			if (bonus)
				rank = Ranking.SECOND_PLACE.getValue();
		}

		return rank;
	}

	private static void reviseScore(List<Integer> ranking, int rank) {
		ranking.set(rank, getScore(ranking, rank));
	}

	private static int getScore(List<Integer> ranking, int index) {
		return ranking.get(index) + Ranking.SCORE.getValue();
	}

	private static boolean checkBonus(List<Integer> candidate, int bonusNumber) {
		return candidate.contains(bonusNumber);
	}

	private static int compareNumbers(List<Integer> candidate, List<Integer> winningNumbers) {
		int count = 0;

		for (int i = 0; i < candidate.size(); i++) {
			if (candidate.contains(winningNumbers.get(i))) {
				count++;
			}
		}

		if (count == Ranking.PERFECT.getValue()) {
			count++;
		}

		return count;
	}

	private static double getRateOfReturn(List<Integer> winningCount, double money) {
		int revenue = sumRevenue(winningCount);

		//반올림
		//rateOfReturn = Math.round(profit*100)/100.0;
		return (revenue / money) * 100;
	}

	private static int sumRevenue(List<Integer> winningCount) {
		int sum = 0;
		List<Integer> prizeMoney = Arrays.asList(5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000);

		for (int i = 0; i < winningCount.size(); i++) {
			sum += winningCount.get(i) * prizeMoney.get(i);
		}

		return sum;
	}
}
