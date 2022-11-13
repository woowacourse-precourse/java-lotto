package lotto.domain;

public class LottoAmount {
	private static final String INPUT_MONEY_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위로 입력하셔야 합니다.";
	private final int purchaseMoney;

	public LottoAmount(int money) {
		validMoney(money);
		this.purchaseMoney = money;
	}

	private static void validMoney(int money) {
		if (isNotDividedInto1000Units(money)) {
			throw new IllegalArgumentException(INPUT_MONEY_ERROR_MESSAGE);
		}
	}

	private static boolean isNotDividedInto1000Units (int money) {
		return money % 1000 != 0;
	}

	public int calculateLottoCount() {
		return purchaseMoney / 1000;
	}

	public int getPurchaseMoney() {
		return purchaseMoney;
	}
}
