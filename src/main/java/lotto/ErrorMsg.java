package lotto;

public enum ErrorMsg {
	LOTTO_NOT_SIX("[ERROR] 로또 번호의 개수가 6개여야 합니다."),
	LOTTO_DUPLICATED("[ERROR] 로또 번호에 중복된 숫자가 있지 않아야 합니다."),
	LOTTO_OUT_OF_RANGE("[ERROR] 로또 번호가 1이상 45이하여야 합니다."),
	STRING_NOT_NATURAL("[ERROR] 띄어쓰기 없는 자연수를 입력해야 합니다."),
	STRING_NOT_MULT_BY_1000("[ERROR] 1000원 단위의 금액을 입력해야 합니다."),
	STRING_NOT_NUMBER_AND_COMMA("[ERROR] 당첨 번호는 쉼표로 구분된 숫자로만 구성되어야 합니다."),
	STRING_OUT_OF_RANGE("[ERROR] 적절한 범위의 보너스 번호를 입력해야 합니다."),
	STRING_ALREADY_IN_LOTTO("[ERROR] 당첨 번호에 포함되지 않은 보너스 번호를 입력해야 합니다.");

	private String message;

	ErrorMsg(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
