package lotto.domain.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.CompareResult;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningRule;

public class LottoService {

	private static final String WINNING_STATISTICS_FORMAT = "%s (%,d원) - %d개";

	private final Map<WinningRule, Integer> winningRuleStatus;

	private List<Lotto> tickets;

	public LottoService() {
		winningRuleStatus = new HashMap<>();
	}

	public void publishTickets(final int numberOfTickets) {
		tickets = LottoGenerator.publish(numberOfTickets);
		tickets.forEach(System.out::println);
	}

	public List<String> getWinningStatistics(List<Integer> winningNumbers, int bonus) {
		for (Lotto lotto : tickets) {
			CompareResult result = lotto.compareTo(winningNumbers, bonus);
			winningRuleStatus.merge(WinningRule.of(result), 1, Integer::sum);
		}
		return Arrays.stream(WinningRule.values())
			.filter(rule -> rule != WinningRule.NONE_MATCH)
			.map(this::formatWinningStatistics)
			.collect(Collectors.toList());
	}

	private String formatWinningStatistics(WinningRule rule) {
		return String.format(WINNING_STATISTICS_FORMAT,
			rule.getStatus(), rule.getPrice(),
			winningRuleStatus.getOrDefault(rule, 0));
	}

	public double getTotalIncomeRatio(final int money) {
		long totalIncome = winningRuleStatus.keySet()
			.stream()
			.map(WinningRule::getPrice)
			.reduce(0L, Long::sum);
		return 100 * (1.0 * totalIncome / money);
	}
}
