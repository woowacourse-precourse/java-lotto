package lotto.domain.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.CompareResult;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningRule;

public class LottoController {

	public void start() {
		System.out.println("구입금액을 입력해 주세요.");
		int money = Integer.parseInt(Console.readLine());

		int numberOfTickets = money / 1_000;
		System.out.println("\n" + numberOfTickets + "개를 구매했습니다.");

		List<Lotto> tickets = LottoGenerator.publish(numberOfTickets);
		tickets.forEach(System.out::println);

		System.out.println("\n당첨번호를 입력해 주세요.");
		List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		System.out.println("\n보너스번호를 입력해 주세요.");
		int bonus = Integer.parseInt(Console.readLine());

		Map<WinningRule, Integer> winningStatus = new HashMap<>();
		for (Lotto lotto : tickets) {
			CompareResult result = lotto.compareTo(winningNumbers, bonus);
			winningStatus.merge(WinningRule.of(result), 1, Integer::sum);
		}

		System.out.println("\n당첨통계");
		System.out.println("---");
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
		System.out.println("총 수익률은 " + totalIncomeRatio + "%입니다.");
	}
}
