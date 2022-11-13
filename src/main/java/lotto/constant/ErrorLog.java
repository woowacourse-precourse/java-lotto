package lotto.constant;

public enum ErrorLog {
	INDIVISIBLE_PURCHASING_AMOUNT_ERROR("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
	NOT_INTEGER_INPUT_ERROR("[ERROR] 정수를 입력해주세요.");

	private final String errorLog;

	ErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}

	public String log() {
		return errorLog;
	}
}
