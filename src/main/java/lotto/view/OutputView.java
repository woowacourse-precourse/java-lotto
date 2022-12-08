package lotto.view;

import static lotto.view.ProgressStatement.*;

import java.util.List;
import java.util.Map;

import lotto.controller.WinStatisticsStatus;
import lotto.model.Lotto;

public class OutputView {
	public static void printErrorMessage(String error) {
		System.out.println(error);
	}

	public static void printProgress(ProgressStatement statement) {
		System.out.println(statement.getProgress());
	}

	public static void printDetails(int ticketQuantity, ProgressStatement statement) {
		System.out.println("\n" + ticketQuantity + statement.getProgress());
	}

	public static void printLotteryTickets(List<Lotto> tickets) {
		for (Lotto ticket : tickets) {
			System.out.println(ticket.getNumbers());
		}
	}

	public static void printWinStatisticsStatus(WinStatisticsStatus[] winStatisticsStatus,
		Map<Integer, Integer> result) {
		for (WinStatisticsStatus rank : winStatisticsStatus) {
			int matchNumber = result.get(rank.getRank());
			rank.showResult(matchNumber);
		}
	}

	public static void printYield(double yield) {
		System.out.println(
			START_GROSS_PROFIT.getProgress() + String.format("%.1f", yield) + END_GROSS_PROFIT.getProgress());
	}
}
