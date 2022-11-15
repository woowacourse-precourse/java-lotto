package lotto.ui;

public enum CustomerMessage {
	INSERT_AMOUNT("구입금액을 입력해 주세요."), 
	PRINT_LOTTO_COUNT("개를 구매했습니다.");

	private final String message;

	CustomerMessage(String value) {
		this.message = value;
	}

	public String getMessage() {
		return message;
	}

}
