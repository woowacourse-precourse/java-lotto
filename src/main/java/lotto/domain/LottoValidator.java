package lotto.domain;

import static lotto.domain.LottoTicketsValidator.*;

import java.util.List;

public class LottoValidator {
	public static void checkValidityAndThrowException(List<Integer> numbers) {
		if (!isConsistOfSixNumbers(numbers)) {
			throw new IllegalArgumentException(ERROR + "1000원 단위의 금액이어야 합니다.");
		}
	}

	private static boolean isConsistOfSixNumbers(List<Integer> numbers) {
		return numbers.size() != 6;
	}

}
