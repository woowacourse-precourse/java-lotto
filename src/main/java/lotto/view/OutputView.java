package lotto.view;

import java.util.EnumMap;

import lotto.constant.OutputMessage;
import lotto.constant.WinningRating;

public class OutputView {
	public void printErrorMessage() {
		System.out.println(OutputMessage.ERROR_MESSAGE.message());
	}
	public void printRateOfProfit(float rateOfProfit) {
		System.out.printf(OutputMessage.DISPLAYING_RATE_OF_PROFIT.message(), rateOfProfit);
	}
	public void printWinningStatistics(EnumMap<WinningRating, Integer> countsOfWins) {
		System.out.println();
		System.out.println(OutputMessage.WINNING_STATISTICS_BEGINNING.message());
		System.out.println(OutputMessage.DIVISION_LINE.message());
		printCountsOfWins(countsOfWins);
	}

	private void printCountsOfWins(EnumMap<WinningRating, Integer> countsOfWins) {
		countsOfWins.forEach((rating, countOfWins) -> {
			if (rating != WinningRating.MISS && rating != WinningRating.SECOND) {
				printCountingPrizeMessage(OutputMessage.COUNTING_PRIZE_WITHOUT_BONUS.message(), rating, countOfWins);
			}
			if (rating == WinningRating.SECOND) {
				printCountingPrizeMessage(OutputMessage.COUNTING_PRIZE_WITH_BONUS.message(), rating, countOfWins);
			}
		});
	}

	private void printCountingPrizeMessage(String message, WinningRating rating, int countOfWins) {
		System.out.printf(message, rating.getCountOfMatchedNumber(), rating.getPrizeMoney(), countOfWins);
		System.out.println();
	}

	public void printNumberOfTickets(int numberOfTickets) {
		System.out.println();
		System.out.printf(OutputMessage.DISPLAYING_PURCHASING_QUANTITY.message(), numberOfTickets);
		System.out.println();
	}
}
