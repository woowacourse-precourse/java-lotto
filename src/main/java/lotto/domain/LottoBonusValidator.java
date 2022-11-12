package lotto.domain;

import static lotto.domain.LottoTicketsValidator.*;

public class LottoBonusValidator {
	public static void validate(int bonusNumber) {
		if (!isValidRange(bonusNumber)) {
			throw new IllegalArgumentException(ERROR + "1부터 45 사이의 숫자여야 합니다.");
		}
	}

	private static boolean isValidRange(int bonusNumber) {
		return bonusNumber >= 1 && bonusNumber <= 45;
	}
}
