package lotto.domain;

import java.util.regex.Pattern;

public class LottoStore {
	private static final String REGEX = "^[0-9]*000$";
	private static final Pattern numberPattern = Pattern.compile(REGEX);
	private static final int MIN_PURCHASE_UNIT = 1000;
	private static final String REGEX_ERROR_MESSAGE = "[ERROR] %d 단위 숫자만 입력해주세요.";
	private static final String ZERO_ERROR_MESSAGE = "[ERROR] 최소 %d원부터 구매 가능합니다.";

	private final int purchaseAmount;
	private final int numberOfTickets;

	public LottoStore(String scanPurchaseAmount) {
		int purchaseAmount = validateREGEX(scanPurchaseAmount);
		validateZero(purchaseAmount);

		this.purchaseAmount = purchaseAmount;
		this.numberOfTickets = purchaseAmount / MIN_PURCHASE_UNIT;
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	private int validateREGEX(String userInput) {
		if (!numberPattern.matcher(userInput).matches()) {
			throw new IllegalArgumentException(String.format(REGEX_ERROR_MESSAGE, MIN_PURCHASE_UNIT));
		}
		return Integer.parseInt(userInput);
	}

	private void validateZero(int purchaseAmount) {
		if (purchaseAmount == 0) {
			throw new IllegalArgumentException(String.format(ZERO_ERROR_MESSAGE, MIN_PURCHASE_UNIT));
		}
	}
}
