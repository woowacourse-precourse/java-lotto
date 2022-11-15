package lotto;

public enum Constant {
	// 로또 번호 관련 상수
	MIN_VALUE(1),
	MAX_VALUE(45),
	NUMBER_OF_NUMBERS(6),
	NUMBER_OF_BONUS_NUMBER(1),
	// 금액 상수
	LOTTO_PRICE(1000),
	FIFTH_PRIZE(5000),
	FOURTH_PRIZE(50000),
	THIRD_PRIZE(1500000),
	SECOND_PRIZE(30000000),
	FIRST_PRIZE(2000000000),
	// 계산 상수
	DIVIDE_RATE(100);
	private final int number;

	Constant(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

}
