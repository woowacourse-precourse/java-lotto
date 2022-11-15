package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Valid {
	private static final int LOTTO_PRICE = 1000;
	private static final int ZERO = 0;

	public static int validatePurchaseAmount(String purchaseAmount) {
		int verification = isNumber(purchaseAmount);

		if (isZero(verification)) {
			System.out.println(Message.PURCHASE_AMOUNT_IS_ZERO_ERROR);
			throw new IllegalArgumentException(Message.PURCHASE_AMOUNT_IS_ZERO_ERROR);
		}
		if(isDividedBy1000(verification))
			return verification;
		System.out.println(Message.NOT_DIVIDED_BY_1000_ERROR);
		throw new IllegalArgumentException(Message.NOT_DIVIDED_BY_1000_ERROR);
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
		System.out.println(Message.INPUT_IS_NOT_NUMBER_ERROR);
		throw new IllegalArgumentException(Message.INPUT_IS_NOT_NUMBER_ERROR);
	}
	private static boolean isZero(int purchaseAmount) {
		if (purchaseAmount == ZERO) {
			return true;
		}
		return false;
	}

	public static void hasDuplicateNumber(List<Integer> numbers) {
		List<Integer> eraseDuplicate = numbers.stream()
										.distinct()
										.collect(Collectors.toList());

		if (eraseDuplicate.size() != numbers.size()) {
			System.out.println(Message.DUPLICATE_IN_LOTTO_NUMBER_ERROR);
			throw new IllegalArgumentException(Message.DUPLICATE_IN_LOTTO_NUMBER_ERROR);
		}
	}

	public static void hasCorrectSizeLotto(List<Integer> numbers) {
		if (numbers.size() != 6) {
			System.out.println(Message.WRONG_SIZE_LOTTO_ERROR);
			throw new IllegalArgumentException(Message.WRONG_SIZE_LOTTO_ERROR);
		}
	}

	private static boolean isNumeric(String str) {
		return str.chars().allMatch(Character::isDigit);
	}
}
