package lotto;

import java.util.List;

public class Verify {

	public static void illegalArgumentException(String message) {
		throw new IllegalArgumentException(message);
	}

	public static void verifyThousandUnit(int money) {
		if (money % Constants.MINIMUM_MONEY_UNIT != 0) {
			throw new IllegalArgumentException(Constants.ERROR_NOT_MONEY_UNIT);
		}
	}

//	public static void verifyGoal(List<Integer> goal) {
//		if
//	}
}
