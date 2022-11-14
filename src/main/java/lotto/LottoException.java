package lotto;

import java.util.regex.Pattern;

public class LottoException {

	public void checkUnitMoney(String money, int price) throws IllegalArgumentException {
		if (Integer.parseInt(money) % price != 0) {
			throw new IllegalArgumentException(Constant.UNIT_MONEY_ERROR);
		}
	}

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

	public void checkInputSize(String[] splitLottoNumber, int length) throws IllegalArgumentException {
		if (splitLottoNumber.length != length) {
			throw new IllegalArgumentException(Constant.INPUT_SIZE_ERROR);
		}
	}

	public void checkNumberSize(String number) throws IllegalArgumentException {
		if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
			throw new IllegalArgumentException(Constant.RANGE_OVER_ERROR);
		}
	}
}
