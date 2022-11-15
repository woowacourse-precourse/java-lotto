package lotto;

public class Verify {

	public static void verifyThousandUnit(int money) {
		if (money % Constants.MINIMUM_MONEY_UNIT != 0) {
			throw new IllegalArgumentException(Constants.ERROR_NOT_MONEY_UNIT);
		}
	}

}
