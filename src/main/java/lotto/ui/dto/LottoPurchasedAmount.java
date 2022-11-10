package lotto.ui.dto;

public class LottoPurchasedAmount {

	private static final int LOTTO_PURCHASED_LIMIT = 100_000;
	private static final int AMOUNT_PER_LOTTO = 1_000;


	private final Integer lotteryPurchasedAmount;

	public LottoPurchasedAmount(String userInput) {
		validate(userInput);
		this.lotteryPurchasedAmount = Integer.parseInt(userInput);
	}

	private void validate(String userInput) {

	}
}
