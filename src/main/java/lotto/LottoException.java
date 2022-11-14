package lotto;

import java.util.regex.Pattern;

public class LottoException {

	public void checkMissMatch(String money) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]*$", money)) {
			throw new IllegalArgumentException(Constant.MONEY_MISSMATCH_ERROR);
		}
	}

	public void checkMoneySize(String money) throws IllegalArgumentException {
		if (Integer.parseInt(money) < 1) {
			throw new IllegalArgumentException(Constant.MONEY_RANGE_ERROR);
		}
	}

}
