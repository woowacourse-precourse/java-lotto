package lotto;

enum Constant {

	PAYMENT_UNIT(1000),
	LOTTO_LENGTH(6);

	int value;

	Constant(int value) {
		this.value = value;
	}
}