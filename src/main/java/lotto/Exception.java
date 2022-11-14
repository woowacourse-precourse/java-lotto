package lotto;

import java.util.List;
import java.util.regex.Pattern;

public class Exception {

	public void checkInputPrice(String input) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]*$", input)) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_PATTERN);
		}
		if (Integer.parseInt(input) <= 0) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_RANGE);
		}
		if (Integer.parseInt(input) % 1000 != 0) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_PRICE);
		}
	}

	public void checkLottoOnlyNumber(String input) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]*$", input)) {
			throw new IllegalArgumentException(Constants.ERROR_LOTTO_ONLY_NUMBER);
		}
	}

	public void checkLottoRange(String input) throws IllegalArgumentException {
		if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
			throw new IllegalArgumentException(Constants.ERROR_LOTTO_RANGE);
		}
	}

	public void reduplicationLottoNumbers(List<Integer> inputList, String input) throws IllegalArgumentException {
		if (inputList.contains(Integer.parseInt(input))) {
			throw new IllegalArgumentException(Constants.ERROR_RE_DUPLICATION_LOTTO);
		}
	}

	public void checkBonusOnlyNumber(String input) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]*$", input)) {
			throw new IllegalArgumentException(Constants.ERROR_BONUS_ONLY_NUMBER);
		}
	}

	public void checkBonusRange(String input) throws IllegalArgumentException {
		if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
			throw new IllegalArgumentException(Constants.ERROR_BONUS_RANGE);
		}
	}
}




