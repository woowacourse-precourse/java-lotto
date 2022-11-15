package lotto.domain.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.CompareResult;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningRule;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

public class LottoController {

	public void start() {
		int money = InputView.getPrice();
		int numberOfTickets = money / 1_000;

		OutputView.displayNumberOfTickets(numberOfTickets);

		List<Lotto> tickets = LottoGenerator.publish(numberOfTickets);
		tickets.forEach(System.out::println);

		List<Integer> winningNumbers = InputView.getNumbers();
		int bonus = InputView.getBonusNumber();

		Map<WinningRule, Integer> winningStatus = new HashMap<>();
		for (Lotto lotto : tickets) {
			CompareResult result = lotto.compareTo(winningNumbers, bonus);
			winningStatus.merge(WinningRule.of(result), 1, Integer::sum);
		}

		OutputView.displayWinningStatistics();

		Arrays.stream(WinningRule.values())
			.filter(rule -> rule != WinningRule.NONE_MATCH)
			.map(rule -> String.format("%s (%,d원) - %d개",
				rule.getStatus(), rule.getPrice(), winningStatus.getOrDefault(rule, 0)))
			.forEach(System.out::println);

		long totalIncome = winningStatus.keySet()
			.stream()
			.map(WinningRule::getPrice)
			.reduce(0L, Long::sum);
		double totalIncomeRatio = 100 * (1.0 * totalIncome / money);
		OutputView.displayIncomeRatio(totalIncomeRatio);
	}
}
