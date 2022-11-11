package lotto;

public enum Notice {
	ERROR("[ERROR]"),
	START("구입금액을 입력해 주세요."),
	PURCHASE("개를 구매했습니다."),
	WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	STATISTICS("당첨 통계\n---"),
	RATE_OF_RETURN("총 수익률은 ");

	private String noticeMessage;

	Notice(String noticeMessage) {
		this.noticeMessage = noticeMessage;
	}

	public String getNoticeMessage() {
		return noticeMessage;
	}
}
