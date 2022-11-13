package lotto.vo;

import lotto.system.validator.IntegerToLottoBuyingInfoValidator;
import lotto.system.validator.StringToLottoBuyingInfoValidator;

public class LottoBuyingInfo {
	private final int money;
	private final int amount;

	public LottoBuyingInfo(int money, int amount) {
		this.money = money;
		this.amount = amount;
	}

	public LottoBuyingInfo(String input) {
		StringToLottoBuyingInfoValidator.validate(input);
		int money = Integer.parseInt(removeCommaFrom(input));
		IntegerToLottoBuyingInfoValidator.validate(money);

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
