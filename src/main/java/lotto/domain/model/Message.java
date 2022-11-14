package lotto.domain.model;

public enum Message {
	START("구입금액을 입력해 주세요."),
	BUY("8개를 구매했습니다."),
	WINNING_NUMBER("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	RESULT("당첨 통계\n---"),
	ERROR("[ERROR] wrong input");

	private final String message;

	private Message(String message) {
		this.message = message;
	}

	public String get() {
		return this.message;
	}
}
