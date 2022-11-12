package lotto.domain;

import static lotto.domain.LottoTicketsValidator.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
	public static void validate(List<Integer> numbers) {
		if (!isConsistOfSixNumbers(numbers)) {
			throw new IllegalArgumentException(ERROR + "중복되지 않은 6개의 숫자를 입력해 주세요.");
		}
		if (isDuplicatedNumbers(numbers)) {
			throw new IllegalArgumentException(ERROR + "중복되지 않은 6개의 숫자를 입력해 주세요.");
		}
		if (!isValidRange(numbers)) {
			throw new IllegalArgumentException(ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
		}
	}

	private static boolean isValidRange(List<Integer> numbers) {
		return numbers.stream().anyMatch(n->n >= 1 && n <= 45);
	}

	private static boolean isConsistOfSixNumbers(List<Integer> numbers) {
		return numbers.size() == 6;
	}

	private static boolean isDuplicatedNumbers(List<Integer> numbers) {
		Set<Integer> set = new HashSet<>(numbers);
		return set.size() != 6;
	}
}
