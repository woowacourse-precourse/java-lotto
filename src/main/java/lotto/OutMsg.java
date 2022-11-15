package lotto;

public enum OutMsg {
	MONEY_REQUEST("구입금액을 입력해 주세요."),
	BUY_SUFFIX("개를 구매했습니다."),
	ANSWER_REQUEST("당첨 번호를 입력해 주세요."),
	BONUS_REQUEST("보너스 번호를 입력해 주세요."),
	ANALYSIS_PREFIX("당첨 통계\n---"),
	THREE_HIT("3개 일치 (5,000원) - "),
	FOUR_HIT("4개 일치 (50,000원) - "),
	FIVE_HIT_WO_BONUS("5개 일치 (1,500,000원) - "),
	FIVE_HIT_W_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	SIX_HIT("6개 일치 (2,000,000,000원) - ");

	private String message;

	OutMsg(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
