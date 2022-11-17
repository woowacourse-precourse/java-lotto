package lotto;

public enum Prize {
	FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
	SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
	FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
	FIFTH(3, 5_000, "3개 일치 (5,000원) - ");

	private int hitNumber;
	private int prizeMoney;
	private String message;

	Prize(int hitNumber, int prizeMoney, String message) {
		this.hitNumber = hitNumber;
		this.prizeMoney = prizeMoney;
		this.message = message;
	}

	public int getHitNumber() {
		return hitNumber;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public String getMessage() {
		return message;
	}

	public static Prize computePrize(int hitNumber, boolean bonusNumber) {
		if (SECOND.getHitNumber() == hitNumber && bonusNumber) {
			return SECOND;
		}
		for (Prize prize : values()) {
			if (prize.getHitNumber() == hitNumber && prize != SECOND) {
				return prize;
			}
		}
		throw new IllegalArgumentException("잘못된 값입니다.");
	}

}
