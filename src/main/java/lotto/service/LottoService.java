package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ExceptionHandler;

public class LottoService {
	public static List<Integer> pickLottoNumbers() {
		List<Integer> lottoNumbers = new ArrayList<>();

		lottoNumbers.addAll(Randoms.pickUniqueNumbersInRange(1,45,6));

		Collections.sort(lottoNumbers);

		return lottoNumbers;
	}

	public static List<List<Integer>> publishLotto(List<List<Integer>> candidateLotto, List<Integer> candidate) {
		candidateLotto.add(candidate);

		return candidateLotto;
	}

	public static List<Integer> convertStringToList(String numbers) {
		List<String> lotto = Arrays.asList(numbers.split(","));
		ExceptionHandler.checkInput(lotto);

		List<Integer> lottoNumbers = lotto.stream()
				.map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());

		return lottoNumbers;
	}
	public static List<Integer> countWinningNumber(List<List<Integer>> candidate, List<Integer> winningNumbers, int bonusNumber) {
		List<Integer> ranking = Arrays.asList(0,0,0,0,0);

		for (int i = 0; i < candidate.size(); i++) {
			int count = compareNumbers(candidate.get(i), winningNumbers);

			if (count == 4 && checkBonus(candidate.get(i), bonusNumber)) {
				count = -1;
			}
			judgementRanking(count, ranking);
		}

		return ranking;
	}
	private static void judgementRanking(int count, List<Integer> ranking) {
		if (count == -1) {
			ranking.set(3, ranking.get(3) + 1);
		}
		if (count == 3) {
			ranking.set(0, ranking.get(0) + 1);
		}
		if (count == 4) {
			ranking.set(1, ranking.get(1) + 1);
		}
		if (count == 5) {
			ranking.set(2, ranking.get(2) + 1);
		}
		if (count == 6)
			ranking.set(4, ranking.get(4) + 1);
	}
	private static boolean checkBonus(List<Integer> candidate, int bonusNumber) {
		if (candidate.contains(bonusNumber))
			return true;
		return false;
	}

	public static int compareNumbers(List<Integer> candidateNumbers, List<Integer> winningNumbers) {
		int count = 0;

		for (int i = 0; i < candidateNumbers.size(); i++) {
			if (candidateNumbers.contains(winningNumbers.get(i))) {
				count++;
			}
		}

		return count;
	}

	public static double getRateOfReturn(List<Integer> winningCount, double money) {
		int revenue = sumRevenue(winningCount);

		double rateOfReturn = (revenue / money) * 100;
		//반올림
		//rateOfReturn = Math.round(profit*100)/100.0;
		return rateOfReturn;
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
