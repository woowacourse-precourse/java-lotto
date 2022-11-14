package lotto;

public enum EnumError {

	INVALID_INPUT("[ERROR] 유효하지 않은 입력입니다."),
	LIMIT_EXCESS("[ERROR] 소액으로 건전하게 즐기세요. 1회차 1인당 구매 한도는 10만원 입니다."),
	DIGIT_MISMATCH("[ERROR] 로또 숫자는 6자리 입니다."),
	OUT_OF_BOUNDS("[ERROR] 1에서 45 사이 숫자를 입력해 주세요."),
	DUPLICATED("[ERROR] 중복된 숫자가 있습니다.");

	private String value;

	EnumError(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
