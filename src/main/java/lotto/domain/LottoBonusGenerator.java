package lotto.domain;

import static lotto.domain.LottoTicketsValidator.*;

import lotto.utils.StringInteger;

public class LottoBonusGenerator {
	public static int generate(String bonusNumber) {
		validate(bonusNumber);
		return StringInteger.toInt(bonusNumber);
	}

	private static void validate(String bonusNumber) {
		if (!isValidCharacter(bonusNumber)) {
			throw new IllegalArgumentException(ERROR + "올바른 숫자를 입력해 주세요.");
		}
	}

	private static boolean isValidCharacter(String bonusNumber) {
		return bonusNumber.matches("^[0-9]+$");
	}
}
