package lotto.domain;

public enum Lottery {
	BANG(6, 0, "꽝"),
	FIFTH_PLACE(5, 5_000, "3개 일치 (5,000원) - %s개"),
	FOURTH_PLACE(4, 50_000, "4개 일치 (50,000원) - %s개"),
	THIRD_PLACE(3, 1_500_000, "5개 일치 (1,500,000원) - %s개"),
	SECOND_PLACE(2, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개"),
	FIRST_PLACE(1, 2_000_000_000, "6개 일치 (2,000,000,000원) - %s개"),
	;

	private final int rank;
	private final int price;
	private final String message;

	Lottery(int rank, int price, String message) {
		this.rank = rank;
		this.price = price;
		this.message = message;
	}

	public static Lottery of(int count, boolean hasBonusNumber) {
		if (count == 6) {
			return FIRST_PLACE;
		} else if (count == 5) {
			if (hasBonusNumber) {
				return SECOND_PLACE;
			}
			return THIRD_PLACE;
		} else if (count == 4) {
			return FOURTH_PLACE;
		} else if (count == 3) {
			return FIFTH_PLACE;
		}
		return BANG;
	}

	public int getRank() {
		return rank;
	}

	public int getPrice() {
		return price;
	}

	public String getMessage() {
		return message;
	}
}
