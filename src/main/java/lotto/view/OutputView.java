package lotto.view;

import java.util.EnumMap;

import lotto.constant.OutputMessage;
import lotto.constant.WinningRating;

public class OutputView {
	public void printWinningStatistics(EnumMap<WinningRating, Integer> countsOfWins) {
		System.out.println();
		System.out.println(OutputMessage.WINNING_STATISTICS_BEGINNING.message());
		System.out.println(OutputMessage.DIVISION_LINE.message());
		countsOfWins.forEach((rating, countOfWins) -> {
			if (rating != WinningRating.SECOND) {
				System.out.printf(OutputMessage.COUNTING_PRIZE_WITHOUT_BONUS.message(),
					rating.getCountOfMatchedNumber(), rating.getPrizeMoney(), countOfWins);
				System.out.println();
			}
			if (rating == WinningRating.SECOND) {
				System.out.printf(OutputMessage.COUNTING_PRIZE_WITH_BONUS.message(), rating.getCountOfMatchedNumber(),
					rating.getPrizeMoney(), countOfWins);
				System.out.println();
			}
		});
	}

	public void printNumberOfTickets(int numberOfTickets) {
		System.out.println();
		System.out.printf(OutputMessage.DISPLAYING_PURCHASING_QUANTITY.message(), numberOfTickets);
		System.out.println();
	}
}
