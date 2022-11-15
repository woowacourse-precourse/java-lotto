package lotto.view;

import static lotto.util.Constants.*;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;

import lotto.service.EarningRate;
import lotto.service.Lotto;
import lotto.util.Rank;

public class Output {
	static DecimalFormat formatter = new DecimalFormat(MONEY_FORMAT);

	public static void printTicketCount(int totalNumberOfLotto) {
		System.out.println(totalNumberOfLotto + OUTPUT_LOTTO_AMOUNT);
	}

	public static void printLotto(List<Lotto> lotteryTickets) {
		for (Lotto lotteryTicket : lotteryTickets) {
			System.out.println(lotteryTicket.getLotto());
		}
	}

	public static void printResult(EnumMap<Rank, Integer> result) {
		System.out.println(STATISTICS);
		System.out.println(STATISTICS_WINNING);
		for (Rank rank : Rank.values()) {
			if (rank == Rank.NOTHING) {
				continue;
			}
			if (rank == Rank.SECOND) {
				printSecondStatistics(result, rank);
				continue;
			}
			printStatistics(result, rank);
		}
	}

	private static void printSecondStatistics (EnumMap<Rank, Integer> result, Rank rank) {
		System.out.println(
			rank.getMatchCount() + STATISTICS_WINNING_COUNT + STATISTICS_WINNING_BONUS
				+ formatter.format(rank.getMoney()) + STATISTICS_WINNING_MONEY
				+ result.get(rank) + STATISTICS_WINNING_COUNT_MONEY);
	}

	private static void printStatistics (EnumMap<Rank, Integer> result, Rank rank) {
		System.out.println(
			rank.getMatchCount() + STATISTICS_WINNING_COUNT_WITH_BRACKET
				+ formatter.format(rank.getMoney()) + STATISTICS_WINNING_MONEY
				+ result.get(rank) + STATISTICS_WINNING_COUNT_MONEY);
	}

	public static void printEarningRate(int paidMoney, Long earningMoney) {
		System.out.println(
			STATISTICS_PROFIT + EarningRate.calculate(paidMoney, earningMoney) + STATISTICS_PROFIT_PERCENT);
	}
}
