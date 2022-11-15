package lotto.domain.view;

public class OutputView {
	public static void displayNumberOfTickets(int numberOfTickets) {
		System.out.println("\n" + numberOfTickets + "개를 구매했습니다.");
	}

	public static void displayWinningStatistics() {
		System.out.println("\n당첨통계");
		System.out.println("---");
	}

	public static void displayIncomeRatio(final double totalIncomeRatio) {
		System.out.println("총 수익률은 " + totalIncomeRatio + "%입니다.");
	}
}
