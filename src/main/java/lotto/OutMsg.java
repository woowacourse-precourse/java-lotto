package lotto;

public enum OutMsg {
	MONEY_REQUEST("구입금액을 입력해 주세요."),
	BUY_SUFFIX("개를 구매했습니다."),
	ANSWER_REQUEST("당첨 번호를 입력해 주세요."),
	BONUS_REQUEST("보너스 번호를 입력해 주세요."),
	ANALYSIS_PREFIX("당첨 통계\n---");

	private String message;

	OutMsg(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
