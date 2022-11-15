package lotto.domain.view;

import java.util.List;

public class OutputView {
	public static void displayNumberOfTickets(int numberOfTickets) {
		System.out.println("\n" + numberOfTickets + "개를 구매했습니다.");
	}

	public static void displayStatistics(List<String> winningStatistics) {
		System.out.println("\n당첨통계");
		System.out.println("---");
		winningStatistics.forEach(System.out::println);
	}

	public static void displayIncomeRatio(final double totalIncomeRatio) {
		System.out.println("총 수익률은 " + totalIncomeRatio + "%입니다.");
	}
}
