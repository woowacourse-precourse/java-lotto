package lotto.domain;

public class Salesman {

	private final static int LOTTO_PRICE = 1000;

	public int sellLotto(int purchaseBudget) {
		validateLittleBudget(purchaseBudget);
		return purchaseBudget / LOTTO_PRICE;
	}

	private void validateLittleBudget(int purchaseBudget) {
		if (purchaseBudget < LOTTO_PRICE) {
			throw new IllegalArgumentException();
		}
	}
}
