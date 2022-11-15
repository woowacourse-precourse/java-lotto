package lotto.domain;

public enum LottoType {
	FIRST(2_000_000_000, 6),
	SECOND(30_000_000, 5),
	THIRD(1_500_000, 5),
	FOURTH(50_000, 4),
	FIFTH(5_000, 3),
	FAIL(0, 0);

	private final int money;
	private final int lottoNumber;

	LottoType(int money, int lottoNumber) {
		this.money = money;
		this.lottoNumber = lottoNumber;
	}

	public int getMoney() {
		return this.money;
	}

	public int getLottoNumber() {
		return this.lottoNumber;
	}
}
