package lotto.domain;

public class Purchaser {
	public static final int LOTTO_PRICE = 1000;

	private int purchaseMoney;
	private int numberOfPurchaseLotto;

	public Purchaser(int purchaseMoneyInput) {
		validate(purchaseMoneyInput);
		this.purchaseMoney = purchaseMoneyInput;
		this.numberOfPurchaseLotto = calculateNumberOfPurchaseLotto(purchaseMoney);
	}

	private void validate(int purchaseMoney) {
		if (purchaseMoney % LOTTO_PRICE > 0) {
			throw new IllegalArgumentException("[ERROR] " + LOTTO_PRICE + "단위 금액으로만 구매 가능합니다.");
		}
	}

	private int calculateNumberOfPurchaseLotto(int purchaseMoney) {
		return purchaseMoney / LOTTO_PRICE;
	}

	public int getNumberOfPurchaseLotto() {
		return numberOfPurchaseLotto;
	}

	public int getPurchaseMoney() {
		return purchaseMoney;
	}
}
