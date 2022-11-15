package lotto;

import java.util.List;

public class Verify {

	public static void illegalArgumentException(String message) {
		throw new IllegalArgumentException(message);
	}

	public static void verifyThousandUnit(int money) {
		if (money % Constants.MINIMUM_MONEY_UNIT != 0) {
			illegalArgumentException(Constants.ERROR_NOT_MONEY_UNIT);
		}
	}

	public static void verifyGoal(List<Integer> goal) {
		verifyLottoLength(goal);
//		verifyNumberBoundary(goal);
//		verifyDupNumber(goal);
	}

	private static void verifyLottoLength(List<Integer> goal) {
		if (goal.size() != Constants.LOTTO_LENGTH) {
			illegalArgumentException(Constants.ERROR_NOT_LOTTO_LENGTH);
		}
	}
}
