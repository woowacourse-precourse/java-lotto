package lotto.domain;

import static lotto.domain.Seller.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

	public static Result calculate(LotteryMachine machine, List<Lotto> tickets) {
		final Map<Lottery, Integer> counts = initializeCounts();
		tickets.forEach(ticket -> {
			final Lottery result = machine.checkResult(ticket);
			counts.replace(result, counts.get(result) + 1);
		});
		return Result.of(counts);
	}

	private static Map<Lottery, Integer> initializeCounts() {
		final Map<Lottery, Integer> counts = new HashMap<>();
		Arrays.stream(Lottery.values())
				.forEach(lottery -> counts.put(lottery, 0));
		return counts;
	}

	public static class Result {

		private final Map<Lottery, Integer> counts;

		private Result(Map<Lottery, Integer> counts) {
			this.counts = counts;
		}

		public static Result of(Map<Lottery, Integer> counts) {
			return new Result(counts);
		}

		public Map<Lottery, Integer> getCounts() {
			return counts;
		}

		public double getRateOfReturn() {
			final long purchaseAmount = getPurchaseAmount();
			final long revenue = getTotalRevenue();
			if (revenue == 0) {
				return 0.0f;
			}
			return Math.round((double)revenue / purchaseAmount * 100 * 10) / 10.0;
		}

		private long getTotalRevenue() {
			return counts.entrySet()
					.stream()
					.mapToLong(entry -> (long)entry.getKey().getPrice() * entry.getValue())
					.sum();
		}

		private long getPurchaseAmount() {
			return counts.values()
					.stream()
					.mapToLong(l -> l)
					.sum() * LOTTO_PRICE;
		}

	}

}
