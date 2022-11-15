package lotto;

public enum Prices {
	LOTTO_PRICE(1000),
	FIFTH_PLACE_PRIZE(5000),
	FORTH_PLACE_PRIZE(50000),
	THIRD_PLACE_PRIZE(1500000),
	SECOND_PLACE_PRIZE(30000000),
	FIRST_PLACE_PRIZE(2000000000);

	private int message;

	Prices(int message) {
		this.message = message;
	}

	public int getPrice() {
		return this.message;
	}

	public int[] getPrize() {
		return new int[] {FIFTH_PLACE_PRIZE.getPrice(), FORTH_PLACE_PRIZE.getPrice(),
			THIRD_PLACE_PRIZE.getPrice(), SECOND_PLACE_PRIZE.getPrice(), FIRST_PLACE_PRIZE.getPrice()};
	}
}
