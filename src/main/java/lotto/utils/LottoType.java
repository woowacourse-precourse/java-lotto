package lotto.utils;

public enum LottoType {
	FIRST(2_000_000_000),
	SECOND(30_000_000),
	THIRD(1_500_000),
	FOURTH(50_000),
	FIFTH(5_000);

	private final int money;

	private LottoType(int money) {
		this.money = money;
	}

	public int getMoney() {
		return this.money;
	}
}
