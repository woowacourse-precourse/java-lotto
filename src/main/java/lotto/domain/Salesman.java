package lotto.domain;

import static lotto.domain.Constants.LOTTO_PRICE;

public class Salesman {

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
