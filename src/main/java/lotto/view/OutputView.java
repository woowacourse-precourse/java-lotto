package lotto.view;

import java.util.List;

public class OutputView {
	public static void printProgress(ProgressStatement statement) {
		newLine();
		System.out.println(statement.getProgress());
	}

	public static void printDetails(int ticketQuantity, ProgressStatement statement) {
		newLine();
		System.out.println(ticketQuantity + statement.getProgress());
	}

	public static void printLotteryTickets(List<List<Integer>> tickets) {
		for (List<Integer> ticket : tickets) {
			System.out.println(ticket);
		}
	}

	public static void newLine() {
		System.out.println();
	}
}
