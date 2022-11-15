package lotto.view;

import java.util.List;

public class OutputView {
	public static void displayNumberOfTickets(int numberOfTickets, List<String> tickets) {
		System.out.println("\n" + numberOfTickets + "개를 구매했습니다.");
		tickets.forEach(System.out::println);
	}

	public static void displayStatistics(List<String> winningStatistics) {
		System.out.println("\n당첨통계");
		System.out.println("---");
		winningStatistics.forEach(System.out::println);
	}

	public static void displayIncomeRatio(final double totalIncomeRatio) {
		System.out.print("총 수익률은 " +
			String.format("%,.1f", totalIncomeRatio) + "%입니다.");
	}
}
