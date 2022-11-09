package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ExceptionHandler;
import lotto.View.Input;

public class lottoController {
	public static int checkQuantityOfLotto() {
		int quantity;
		int money = Integer.parseInt(Input.buyLotto());

		ExceptionHandler.checkMoney(money);
		quantity = money / 1000;

		return quantity;
	}

	public static List<List<Integer>> publishLotto(List<List<Integer>> candidateLotto, List<Integer> candidate) {
		candidateLotto.add(candidate);

		return candidateLotto;
	}

	public static List<Integer> pickLottoNumbers() {
		List<Integer> lottoNumbers = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			lottoNumbers.add(pickRandomNumber(lottoNumbers));
		}

		lottoNumbers.sort(Comparator.naturalOrder());

		return lottoNumbers;
	}

	private static int pickRandomNumber(List<Integer> lottoNumbers) {
		int number = Randoms.pickNumberInRange(1, 45);

		if (lottoNumbers.size() == 0) {
			return number;
		}
		while (lottoNumbers.contains(number)) {
			number = Randoms.pickNumberInRange(1, 45);
		}

		return number;
	}

	public static List<Integer> pickWinningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요");
		String winningNumbers = Input.pickWinningNumbers();
		List<String> lotto = Arrays.asList(winningNumbers.split(","));

		List<Integer> lottoNumbers = lotto.stream()
				.map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());

		return lottoNumbers;
	}

	public static int pickBonusNumbers() {
		System.out.println("보너스 번호를 입력해 주세요");
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

	private static boolean checkSameNumber(int a, int b) {
		if (a == b)
			return true;
		return false;
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

	public static double calculateProfit(List<Integer> winningCount, int money) {
		int prizeMoney = sumPrizeMoney(winningCount);

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
