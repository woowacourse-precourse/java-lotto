package lotto.model;

public enum LotteryInformation {
	UNIT_PRICE(1000), START_NUMBER(1), END_NUMBER(45), TOTAL_NUMBER(6), BONUS_NUMBER_DIGIT(6), CHECK_BONUS(100);
	private final int code;

	LotteryInformation(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
