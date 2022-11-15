package lotto.service;

import static lotto.message.ErrorMessageConstants.*;
import static lotto.restrict.RestrictConstants.*;

public class UserService {

	public Integer getLottoQuantity(Long amount) {
		checkAmount(amount);
		return calculateQuantity(amount);
	}

	private void checkAmount(long amount) {
		if (amount % AMOUNT_UNIT != 0 || amount <= 0) {
			throw new IllegalArgumentException(String.format(UNIT_ERROR_MESSAGE_FORMAT, AMOUNT_UNIT));
		}
	}

	private int calculateQuantity(long amount) {
		return (int) (amount / AMOUNT_UNIT);
	}
}
