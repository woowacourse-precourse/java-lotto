package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum WinningRule {
	THREE_MATCH("3개 일치",
		(result) -> result.getMatches() == 3, 5_000),
	FOUR_MATCH("4개 일치",
		(result) -> result.getMatches() == 4, 50_000),
	FIVE_MATCH("5개 일치",
		(result) -> result.getMatches() == 5, 1_500_000),
	BONUS_MATCH("5개 일치, 보너스 볼 일치",
		(result) -> result.getMatches() == 5 && result.containsBonus(), 30_000_000),
	ALL_MATCH("6개 일치",
		(result) -> result.getMatches() == 6, 2_000_000_000),
	NONE_MATCH("0개 일치",
		(result) -> result.getMatches() < 3, 0);

	private final String status;

	private final Predicate<CompareResult> condition;

	private final long price;

	WinningRule(String status, Predicate<CompareResult> condition, long price) {
		this.status = status;
		this.condition = condition;
		this.price = price;
	}

	public static WinningRule of(final CompareResult result) {
		return Arrays.stream(values())
			.filter(rule -> rule.condition.test(result))
			.findFirst()
			.orElse(NONE_MATCH);
	}

	public long getPrice() {
		return price;
	}

	public String getStatus() {
		return status;
	}

	public boolean isNotNoneMatch() {
		return this != NONE_MATCH;
	}
}
