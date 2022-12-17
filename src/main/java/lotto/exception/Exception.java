package lotto.exception;

public enum Exception {
	NUMBER_ONLY_EXCEPTION(new IllegalArgumentException("[ERROR] " + "숫자만 입력가능합니다.")),
	MAX_PRICE_EXCEPTION(new IllegalArgumentException("[ERROR] " + "1인 구매 가능 금액은 10만원입니다.")),
	MIN_PRICE_EXCEPTION(new IllegalArgumentException("[ERROR] " + "1000원 이상의 금액을 입력해주세요.")),
	PRICE_RANGE_EXCEPTION(new IllegalArgumentException("[ERROR] " + "1000원 단위의 금액을 입력해주세요")),
	LENGTH_EXCEPTION(new IllegalArgumentException("[ERROR] " + "올바른 개수의 숫자를 입력해주세요.")),
	SAME_NUMBER_EXCEPTION(new IllegalArgumentException("[ERROR] " + "중복되는 수가 존재합니다.")),
	NUMBER_RANGE_EXCEPTION(new IllegalArgumentException("[ERROR]" + "1~45까지의 숫자만 입력 가능합니다."));

	private IllegalArgumentException exception;

	Exception(IllegalArgumentException exception) {
		this.exception = exception;
	}

	public IllegalArgumentException getException() {
		return exception;
	}
}
