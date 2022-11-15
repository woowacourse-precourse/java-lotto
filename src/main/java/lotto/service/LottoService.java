package lotto.service;

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

	private final String WINNING_STATISTICS_FORMAT = "%s (%,d원) - %d개";

	private final Map<WinningRule, Integer> winningRuleStatus;

	private List<Lotto> lottos;

	public LottoService() {
		winningRuleStatus = new HashMap<>();
	}

	public List<String> publishTickets(final int numberOfTickets) {
		lottos = LottoGenerator.publish(numberOfTickets);
		return lottos.stream()
			.map(Lotto::toString)
			.collect(Collectors.toList());
	}

	public List<String> getWinningStatistics(final List<Integer> winningNumbers,
		int bonus) {

		initWinningStatus(winningNumbers, bonus);
		return Arrays.stream(WinningRule.values())
			.filter(WinningRule::isNotNoneMatch)
			.map(this::formatWinningStatistics)
			.collect(Collectors.toList());
	}

	void initWinningStatus(final List<Integer> winningNumbers, int bonus) {
		for (Lotto lotto : lottos) {
			CompareResult result = lotto.compareTo(winningNumbers, bonus);
			winningRuleStatus.merge(WinningRule.of(result), 1, Integer::sum);
		}
	}

	private String formatWinningStatistics(WinningRule rule) {
		return String.format(WINNING_STATISTICS_FORMAT,
			rule.getStatus(), rule.getPrice(),
			winningRuleStatus.getOrDefault(rule, 0));
	}

	public double getRateOfReturn(final int totalInvestment) {
		double winningAmount = winningRuleStatus.keySet()
			.stream()
			.map(WinningRule::getPrice)
			.reduce(0L, Long::sum);
		return (winningAmount / totalInvestment) * 100;
	}
}
