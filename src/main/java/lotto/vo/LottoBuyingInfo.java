package lotto.vo;

import lotto.system.holder.ValidationHolder;

public class LottoBuyingInfo {
	private final int money;
	private final int amount;

	public LottoBuyingInfo(int money, int amount) {
		this.money = money;
		this.amount = amount;
	}

	public LottoBuyingInfo(String input) {
		ValidationHolder.validate(input, LottoBuyingInfo.class);
		int money = Integer.parseInt(removeCommaFrom(input));
		ValidationHolder.validate(money, LottoBuyingInfo.class);

		this.money = money;
		this.amount = money / 1000;
	}

	private static String removeCommaFrom(String target) {
		return target.replaceAll(",", "");
	}

	public int getMoney() {
		return money;
	}

	public int getAmount() {
		return amount;
	}
}
