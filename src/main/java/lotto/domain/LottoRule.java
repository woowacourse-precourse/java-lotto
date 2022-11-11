package lotto.domain;

public enum LottoRule {
	MIN_NUMBER(1),
	MAX_NUMBER(45),
	NUMBER_COUNT(6),
	LOTTO_COST(1000);

	private final int value;

	LottoRule(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
