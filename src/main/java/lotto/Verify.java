package lotto;

import java.util.List;

public class Verify {

	public static void illegalArgumentException(String message) {
//		System.out.println(message);
		throw new IllegalArgumentException(message);
	}

	public static void verifyMoneyUnit(int money) {
		if (money % Constants.MINIMUM_MONEY_UNIT != 0) {
			illegalArgumentException(Constants.ERROR_NOT_MONEY_UNIT);
		}
	}

	public static void verifyGoal(List<Integer> goal) {
		verifyLottoLength(goal);
		verifyNumberBoundary(goal);
	}

	public static void verifyLottoLength(List<Integer> goal) {
		if (goal.size() != Constants.LOTTO_LENGTH) {
			illegalArgumentException(Constants.ERROR_NOT_LOTTO_LENGTH);
		}
	}

	private static void verifyNumberBoundary(List<Integer> goal) {
		for (Integer number : goal) {
			if (number < Constants.LOTTO_UNDER_BOUNDARY || number > Constants.LOTTO_UPPER_BOUNDARY) {
				illegalArgumentException(Constants.ERROR_NOT_IN_BOUNDARY);
			}
		}
	}

	private static void verifyNumberBoundary(int number) {
		if (number < Constants.LOTTO_UNDER_BOUNDARY || number > Constants.LOTTO_UPPER_BOUNDARY) {
			illegalArgumentException(Constants.ERROR_NOT_IN_BOUNDARY);
		}
	}

	public static boolean[] verifyDupNumber(List<Integer> goal) {
		boolean[] dupCheck = new boolean[Constants.LOTTO_UPPER_BOUNDARY+1];

		for (Integer number : goal) {
			if (dupCheck[number]) {
				illegalArgumentException(Constants.ERROR_DUP_NUMBER);
			}
			dupCheck[number] = true;
		}

		return dupCheck;
	}

	private static void verifyDupNumber(int bonusNumber, boolean[] goal) {
		if (goal[bonusNumber]) {
			illegalArgumentException(Constants.ERROR_DUP_NUMBER);
		}
	}

	public static void verifyBonus(int bonusNumber, boolean[] goal) {
		verifyDupNumber(bonusNumber, goal);
		verifyNumberBoundary(bonusNumber);
	}
}
