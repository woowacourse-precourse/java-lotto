package lotto.vo;

public class LottoBuyingInfo {
	private final int money;
	private final int amount;

	public LottoBuyingInfo(int money, int amount) {
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
