package lotto.controller;

import static lotto.service.LottoService.*;

import java.util.ArrayList;
import java.util.List;

import lotto.ExceptionHandler;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
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
		String winningNumbers = Input.pickWinningNumbers();
		ExceptionHandler.checkSpilt(winningNumbers);

		return LottoService.convertStringToList(winningNumbers);
	}

	public static int pickBonusNumbers() {
		String bonusNumber = Input.pickWinningNumbers();

		ExceptionHandler.checkBonus(bonusNumber);

		return Integer.parseInt(bonusNumber);
	}

	public static List<Integer> getWinningRanking(List<List<Integer>> candidate, List<Integer> winningNumbers, int bonusNumber) {
		/*
		List<Integer> ranking = Arrays.asList(0,0,0,0,0);

		for (int i = 0; i < candidate.size(); i++) {
			int count = compareNumbers(candidate.get(i), winningNumbers);
			if (count == 3)
				ranking.set(0, ranking.get(0) + 1);
			if (count == 4)
				ranking.set(1, ranking.get(1) + 1);
			if (count == 5)
				ranking.set(2, ranking.get(2) + 1);
			if (count == 5 && candidate.get(i).contains(bonusNumbers))
				ranking.set(3, ranking.get(3) + 1);
			if (count == 6)
				ranking.set(4, ranking.get(4) + 1);
		}
		 */
		return LottoService.countWinningNumber(candidate, winningNumbers, bonusNumber);
	}

	public static double calculateProfit(List<Integer> winningCount, double money) {
		return LottoService.getRateOfReturn(winningCount, money);
	}
}
