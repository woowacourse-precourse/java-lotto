package lotto.domain;

public class LottoAmount {
	private final int purchaseMoney;

	public LottoAmount(int money) {
		validMoney(money);
		this.purchaseMoney = money;
	}

	private void validMoney(int money) {
		if (isNotDividedInto1000Units(money)) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력하셔야 합니다.");
		}
	}

	private boolean isNotDividedInto1000Units (int money) {
		return money % 1000 != 0;
	}

	public int calculateLottoCount() {
		return purchaseMoney / 1000;
	}
}
