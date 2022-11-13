package lotto.view;

import java.util.List;

import lotto.constant.OutputMessage;
import lotto.constant.WinningRating;

public class OutputView {
	/***
	public void printWinningStatistics(List<Integer> numbersOfWins) {
		System.out.println(OutputMessage.WINNING_STATISTICS_BEGINNING.message());
		System.out.println(OutputMessage.DIVISION_LINE.message());
		for (int index = 0; index < WinningRating.values().length; index++) {
			if (index == 3) {
				System.out.printf(OutputMessage.COUNTING_PRIZE_WITH_BONUS.message(), WinningRating.values().)
			}
			System.out.printf(OutputMessage.COUNTING_PRIZE_WITHOUT_BONUS.message(), winningRating.getCountOfMatchedNumber(), winningRating.getPrizeMoney(),

		}
	}
	 ***/
	public void printNumberOfTickets(int numberOfTickets) {
		System.out.println();
		System.out.printf(OutputMessage.DISPLAYING_PURCHASING_QUANTITY.message(), numberOfTickets);
		System.out.println();
	}
}
