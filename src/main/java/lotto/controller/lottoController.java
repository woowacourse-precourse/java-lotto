package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ExceptionHandler;
import lotto.View.Input;

public class lottoController {

	private static int checkQuantityOfLotto() {
		int quantity;
		int money = Integer.parseInt(Input.buyLotto());

		ExceptionHandler.checkMoney(money);
		quantity = money / 1000;

		return quantity;
	}

	public static List<List<Integer>> publishLotto(int quantity) {
		List<List<Integer>> candidateLotto = new ArrayList<>();

		for (int i = 0; i < quantity; i++) {
			candidateLotto.add(pickLottoNumbers());
		}
		return candidateLotto;
	}

	private static List<Integer> pickLottoNumbers() {
		List<Integer> lottoNumbers = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			lottoNumbers.add(pickRandomNumber(lottoNumbers));
		}
		return lottoNumbers;
	}

	private static int pickRandomNumber(List<Integer> lottoNumbers) {
		int number = Randoms.pickNumberInRange(1, 45);

		if (lottoNumbers.size() == 0) {
			return number;
		}
		while (lottoNumbers.contains(number))
			number = Randoms.pickNumberInRange(1, 45);

		return number;
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

	private static int compareNumbers(List<Integer> candidateNumbers, List<Integer> winningNumbers) {
		int count = 0;

		for (int i = 0; i < candidateNumbers.size(); i++) {
			if (checkSameNumber(candidateNumbers.get(i), winningNumbers.get(i))) {
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

	private static List<Integer> countWinningLotto() {
		List<Integer> winningCount = new ArrayList<>();

		List<List<Integer>> lotto = publishLotto(Integer.parseInt(Input.buyLotto()));
		for (int i = 0; i < lotto.size(); i++) {
			winningCount.add(compareNumbers(lotto.get(i), pickWinningNumbers()));
		}

		return winningCount;
	}

	private static double calculateProfit(List<Integer> winningCount, int money) {
		int prizeMoney = sumPrizeMoney(winningCount);

		double profit = (prizeMoney/money) * 100;

		//반올림
		profit = Math.round(profit*100)/100.0;

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
