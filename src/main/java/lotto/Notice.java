package lotto;

public enum Notice {
	start("구입금액을 입력해 주세요."),
	purchase("개를 구매했습니다."),
	winningNumbers("당첨 번호를 입력해 주세요."),
	bonusNumber("보너스 번호를 입력해 주세요."),
	statistics("당첨 통계\n---"),
	profit("총 수익률은 ");

	private String noticeMessage;

	Notice(String noticeMessage) {
		this.noticeMessage = noticeMessage;
	}

	public String getNoticeMessage() {
		return noticeMessage;
	}
}
