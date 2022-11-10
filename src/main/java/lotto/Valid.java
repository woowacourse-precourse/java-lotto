package lotto;

public class Valid {
	private static final int LOTTO_PRICE = 1000;
	private static final int ZERO = 0;
	private static final String INPUT_PURCHASE_AMOUNT_ERROR = "[ERROR]구입금액 입력이 잘못 되었습니다.";

	public static int validatePurchaseAmount(String purchaseAmount) {
		int verification = isNumber(purchaseAmount);
		if(isDividedBy1000(verification))
			return verification;
		throw new IllegalArgumentException(INPUT_PURCHASE_AMOUNT_ERROR);
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
		throw new IllegalArgumentException(INPUT_PURCHASE_AMOUNT_ERROR);
	}

	private static boolean isNumeric(String str) {
		return str.chars().allMatch(Character::isDigit);
	}
}
