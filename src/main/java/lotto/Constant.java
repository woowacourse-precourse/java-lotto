package lotto;

enum Constant {

	PAYMENT_UNIT(1000),
	LOTTO_STARTING_NUMBER(1),
	LOTTO_ENDING_NUMBER(45),
	LOTTO_LENGTH(6);

	int value;

	Constant(int value) {
		this.value = value;
	}
}