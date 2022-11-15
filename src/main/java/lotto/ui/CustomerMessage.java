package lotto.ui;

public enum CustomerMessage {
	INSERT_AMOUNT("구입금액을 입력해 주세요.");

	private final String message;

	CustomerMessage(String value) {
		this.message = value;
	}

	public String getMessage() {
		return message;
	}

}
