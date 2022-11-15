package lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class validator {
	public static void validateWinningNumber(ArrayList<Integer> integers) {
		for (int i = 0; integers.size() > i; i++) {
			if (integers.get(i) < 1 || integers.get(i) > 45) {
				throw new IllegalArgumentException("[ERROR]");
			}
		}
		Set<Integer> hashIntegers = new HashSet<>(integers);
		if (integers.size() != hashIntegers.size()) {
			throw new IllegalArgumentException("[ERROR]");
		}
		if (integers.size() != 6) {
			throw new IllegalArgumentException("[ERROR]");
		}
	}
	public static void validateBonusNumber(ArrayList<Integer> winningNumber, int bonusNumber) {
		if (bonusNumber > 45 || bonusNumber < 1) {
			throw new IllegalArgumentException("[ERROR]");
		}
		for (int i = 0; winningNumber.size() > i; i++) {
			if (winningNumber.get(i) == bonusNumber) {
				throw new IllegalArgumentException("[ERROR]");
			}
		}

	}
	public static void validateBudget(int budget) {
		if (budget < 1000) {
			throw new IllegalArgumentException("[ERROR]");
		}
		if (budget % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR]");
		}
	}
}
