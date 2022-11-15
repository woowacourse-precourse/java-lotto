package lotto.domain.money;

import static lotto.util.constant.Constant.LOTTO_PURCHASE_AMOUNT;

public class Money {


	private static final String LOTTO_PURCHASE_AMOUNT_NOT_ZERO = "[ERROR] 금액은 0원이 되면 안됩니다.";
	private static final String LOTTO_PURCHASE_AMOUNT_NOT_1000_UNIT =
			"[ERROR] 구입 금액은 " + LOTTO_PURCHASE_AMOUNT + "원단위 여야 합니다.";
	private static final String LOTTO_PURCHASE_AMOUNT_IS_NUMBER = "[ERROR] 구매 금액은 숫자 여야 합니다.";
	int money;

	public Money(String money) {
		validate(money);
	}

	public int getLottoPurchaseCount() {
		return money / LOTTO_PURCHASE_AMOUNT;
	}

	public void validate(String money) {
		isNumber(money);
		this.money = Integer.parseInt(money);
		isGreaterThanZero(this.money);
		isRemainderZero(this.money);

	}

	public void isGreaterThanZero(int money) {
		if (money == 0) {
			throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT_NOT_ZERO);
		}
	}

	public void isRemainderZero(int money) {
		int remainderNumber = money % LOTTO_PURCHASE_AMOUNT;
		if (remainderNumber != 0) {
			throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT_NOT_1000_UNIT);
		}
	}

	public void isNumber(String money) {
		try {
			Long.parseLong(money);
		} catch (Exception e) {
			throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT_IS_NUMBER);
		}
	}

	public int getMoney() {
		return money;
	}
}
