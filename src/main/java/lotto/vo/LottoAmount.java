package lotto.vo;

public class LottoAmount {
	private final int money;
	private final int amount;

	public LottoAmount(int money, int amount) {
		this.money = money;
		this.amount = amount;
	}

	public int getMoney() {
		return money;
	}

	public int getAmount() {
		return amount;
	}
}
