package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.view.Input;

public class LottoController {
	public static List<List<Integer>> publishLotteries(int quantity) {
		List<List<Integer>> candidate = new ArrayList<>();

		for (int i = 0; i < quantity; i++) {
			Lotto lotto = new Lotto(pickLottoNumbers());
			publishLotto(candidate, lotto.getNumbers());
			System.out.println(candidate.get(i));
		}

		return candidate;
	}
	public static List<List<Integer>> publishLotto(List<List<Integer>> candidateLotto, List<Integer> candidate) {
		candidateLotto.add(candidate);

		return candidateLotto;
	}

	public static List<Integer> pickLottoNumbers() {
		List<Integer> lottoNumbers = new ArrayList<>();

		lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);

		lottoNumbers.stream()
				.sorted();

		return lottoNumbers;
	}

	public static List<Integer> pickWinningNumbers() {
		String winningNumbers = Input.pickWinningNumbers();
		List<String> lotto = Arrays.asList(winningNumbers.split(","));

		List<Integer> lottoNumbers = lotto.stream()
				.map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());

		return lottoNumbers;
	}

	public static int pickBonusNumbers() {
		String bonusNumber = Input.pickWinningNumbers();

		return Integer.parseInt(bonusNumber);
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

	public static List<Integer> countWinningLotto(List<List<Integer>> lotto, List<Integer> winningNumbers, int bonusNumbers, int quantity) {
		List<Integer> winningCount = Arrays.asList(0,0,0,0,0);

		for (int i = 0; i < lotto.size(); i++) {
			int count = compareNumbers(lotto.get(i), winningNumbers);
			if (count == 3)
				winningCount.set(0, winningCount.get(0) + 1);
			if (count == 4)
				winningCount.set(1, winningCount.get(1) + 1);
			if (count == 5)
				winningCount.set(2, winningCount.get(2) + 1);
			if (count == 5 && lotto.get(i).contains(bonusNumbers))
				winningCount.set(3, winningCount.get(3) + 1);
			if (count == 6)
				winningCount.set(4, winningCount.get(4) + 1);
		}

		return winningCount;
	}

	public static double calculateProfit(List<Integer> winningCount, double money) {
		double prizeMoney = sumPrizeMoney(winningCount);

		double profit = (prizeMoney/money) * 100;


		//반올림
		//profit = Math.round(profit*100)/100.0;

		return profit;
	}

	private static int sumPrizeMoney(List<Integer> winningCount) {
		int sum = 0;
		List<Integer> prizeMoney = Arrays.asList(5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000);

		for (int i = 0; i < winningCount.size(); i++) {
			sum += winningCount.get(i) * prizeMoney.get(i);
		}

		return sum;
	}
}
