package lotto;

public class Valid {
	private static final int LOTTO_PRICE = 1000;
	private static final int ZERO = 0;
	private static final String NOT_DIVIDED_BY_1000_ERROR = "[ERROR]구입금액이 1000원 단위가 아닙니다.";
	private static final String PURCHASE_AMOUNT_IS_ZERO_ERROR = "[ERROR]구입 금액이 0원입니다.";
	private static final String INPUT_IS_NOT_NUMBER_ERROR = "[ERROR]구입금액이 숫자가 아닙니다.";

	public static int validatePurchaseAmount(String purchaseAmount) {
		int verification = isNumber(purchaseAmount);

		if (isZero(verification)) {
			System.out.println(PURCHASE_AMOUNT_IS_ZERO_ERROR);
			throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_ZERO_ERROR);
		}
		if(isDividedBy1000(verification))
			return verification;
		System.out.println(NOT_DIVIDED_BY_1000_ERROR);
		throw new IllegalArgumentException(NOT_DIVIDED_BY_1000_ERROR);
	}

	private static boolean isDividedBy1000(int verification) {
		if(verification % LOTTO_PRICE == ZERO)
			return true;
		return false;
	}

	private static int isNumber(String purchaseAmount) {
		if (isNumeric(purchaseAmount)) {
			return Integer.parseInt(purchaseAmount);
		}
		System.out.println(INPUT_IS_NOT_NUMBER_ERROR);
		throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER_ERROR);
	}
	private static boolean isZero(int purchaseAmount) {
		if (purchaseAmount == ZERO) {
			return true;
		}
		return false;
	}

	private static boolean isNumeric(String str) {
		return str.chars().allMatch(Character::isDigit);
	}
}
