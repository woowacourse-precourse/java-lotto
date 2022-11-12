package lotto.domain;

public enum Prize {
	FIFTH_PRIZE(5000,3,0,"3개 일치 (5,000원) - "),
	FOURTH_PRIZE(50000,4,0,"4개 일치 (50,000원) - "),
	THIRD_PRIZE(1500000,5,0,"5개 일치 (1,500,000원) - "),
	SECOND_PRIZE(30000000,6,0,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIRST_PRIZE(2000000000,7,0,"6개 일치 (2,000,000,000원) - ");

	private final int prize;
	private final int matchCount;
	private final String message;
	private int prizeCount;

	Prize(int prize,int matchCount,int prizeCount,String message){
		this.prize = prize;
		this.matchCount = matchCount;
		this.prizeCount = prizeCount;
		this.message = message;
	}

	public int getPrize() {
		return prize;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrizeCount() {
		return prizeCount;
	}

	public String getMessage() {
		return message;
	}

	public void enhancePrizeCount() {
		this.prizeCount++;
	}

	public void initPrizeCount() {
		this.prizeCount = 0;
	}
}
