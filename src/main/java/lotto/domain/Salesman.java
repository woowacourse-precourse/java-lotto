package lotto.domain;

import static lotto.ErrorMessage.INDIVISIBLE_ERROR_MESSAGE;
import static lotto.ErrorMessage.LITTLE_BUDGET_ERROR_MESSAGE;
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
			throw new IllegalArgumentException(LITTLE_BUDGET_ERROR_MESSAGE);
		}
	}

	private void validateIndivisibleBudget(int purchaseBudget) {
		if (purchaseBudget % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(INDIVISIBLE_ERROR_MESSAGE);
		}
	}
}
