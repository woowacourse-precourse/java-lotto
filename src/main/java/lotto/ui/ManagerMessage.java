package lotto.ui;

public enum ManagerMessage {
	INSERT_WIN_NUMBERS("당첨 번호를 입력해 주세요.");

	private final String message;

	ManagerMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
