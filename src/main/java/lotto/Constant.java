package lotto;

enum Constant {

	PAYMENT_UNIT(1000),
	
	LOTTO_STARTING_NUMBER(1),
	LOTTO_ENDING_NUMBER(45),
	LOTTO_NUMBERS_LENGTH(6),
	
	FIRST_PLACE(1, 6, 2000000000, "6개 일치 (2,000,000,000원) - "),
	SECOND_PLACE(2, 5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	THIRD_PLACE(3, 5, 1500000, "5개 일치 (1,500,000원) - "),
	FOURTH_PLACE(4, 4, 50000, "4개 일치 (50,000원) - "),
	FIFTH_PLACE(5, 3, 5000, "3개 일치 (5,000원) - ");

	int value;
	int condition;
	int prizeMoney;
	String resultMessage;

	Constant(int value) {
		this.value = value;
	}
	
	Constant(int value, int condition, int prizeMoney, String resultMessage) {
		this.value = value;
		this.condition = condition;
		this.prizeMoney = prizeMoney;
		this.resultMessage = resultMessage;
	}
}