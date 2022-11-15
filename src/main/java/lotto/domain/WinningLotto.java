package lotto.domain;

import static lotto.common.exception.ErrorMessage.*;
import static lotto.domain.Lotto.*;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
	private static List<Integer> winningLotto;
	private static int bonusNumber;

	public static void createWinningLotto(String winningLottoString) {
		validateLottoString(winningLottoString);
		parseLotto(winningLottoString);
		validateLottoNumbers(winningLotto);
		validateDuplicate(winningLotto);
	}

	private static void validateLottoString(String winningLottoString) {
		validateLottoStringIsNull(winningLottoString);
		validateLottoStringSize(winningLottoString);
		validateLottoStringIsNumber(winningLottoString);
	}

	private static void validateDuplicate(List<Integer> winningLotto) {
		if (winningLotto.stream().distinct().count() != winningLotto.size()) {
			throw new IllegalArgumentException(NOT_VALID_LOTTO_DUPLICATE);
		}
	}

	private static void validateLottoStringIsNull(String winningLottoString) {
		if (winningLottoString == null) {
			throw new IllegalArgumentException(NOT_VALID_WINNING_LOTTO_NULL);
		}
	}

	private static void validateLottoStringSize(String winningLottoString) {
		if (winningLottoString.split(",").length != 6) {
			throw new IllegalArgumentException(NOT_VALID_WINNING_LOTTO_SIZE);
		}
	}

	private static void validateLottoStringIsNumber(String winningLottoString) {
		for (String number : winningLottoString.split(",")) {
			try {
				Integer.parseInt(number);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(NOT_VALID_WINNING_LOTTO_NUMBER);
			}
		}
	}

	private static void parseLotto(String winningLottoString) {
		List<String> lottoNumbersString = List.of(winningLottoString.split(","));
		winningLotto = lottoNumbersString.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public static void createBonusNumber(String bonusNumberString) {
		validateBonusNumberString(bonusNumberString);
		bonusNumber = Integer.parseInt(bonusNumberString);
	}

	private static void validateBonusNumberString(String bonusNumberString) {
		validateBonusNumberIsNull(bonusNumberString);
		validateIsNumber(bonusNumberString);
		validateBonusNumber(Integer.parseInt(bonusNumberString));
	}

	private static void validateBonusNumberIsNull(String bonusNumberString) {
		if (bonusNumberString == null) {
			throw new IllegalArgumentException(NOT_VALID_BONUS_NUMBER_NULL);
		}
	}

	private static void validateIsNumber(String bonusNumberString) {
		try {
			Integer.parseInt(bonusNumberString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_VALID_INPUT_NOT_NUMERIC);
		}
	}

	private static void validateBonusNumber(int bonusNumber) {
		validateConflict(bonusNumber);
		validateInputRange(bonusNumber);
	}

	private static void validateConflict(int bonusNumber) {
		if (winningLotto.contains(bonusNumber)) {
			throw new IllegalArgumentException(CONFLICT_BONUS_NUMBER_WITH_WINNING_NUMBER);
		}
	}

	private static void validateInputRange(int number) {
		if (!numberCache.containsKey(number)) {
			throw new IllegalArgumentException(NOT_VALID_NUMBER);
		}
	}

	public static List<Integer> getWinningLotto() {
		return winningLotto;
	}

	public static int getBonusNumber() {
		return bonusNumber;
	}

}
