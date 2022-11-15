package lotto.domain;

public class CompareResult {

	private final int matchingNumbers;

	private final boolean containsBonus;

	public CompareResult(final int matchingNumbers, final boolean containsBonus) {
		this.matchingNumbers = matchingNumbers;
		this.containsBonus = containsBonus;
	}

	public int getMatches() {
		return matchingNumbers;
	}

	public boolean containsBonus() {
		return containsBonus;
	}
}
