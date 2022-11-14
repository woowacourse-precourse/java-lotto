package lotto.domain;

public class Salesman {

	private final static int LOTTO_PRICE = 1000;

	public int sellLotto(int purchaseBudget) {
		validate(purchaseBudget);
		return purchaseBudget / LOTTO_PRICE;
	}

	private void validate(int purchaseBudget) {
		validateLittleBudget(purchaseBudget);
		validateIndivisibleBudget(purchaseBudget);
	}

	private void validateLittleBudget(int purchaseBudget) {
		if (purchaseBudget < LOTTO_PRICE) {
			throw new IllegalArgumentException();
		}
	}

	private void validateIndivisibleBudget(int purchaseBudget) {
		if (purchaseBudget % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException();
		}
	}
}
