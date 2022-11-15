package lotto.domain.view;

public enum Message {
	START("구입금액을 입력해 주세요.\n"),
	BUY("개를 구매했습니다.\n"),
	WINNING_NUMBER("당첨 번호를 입력해 주세요.\n"),
	BONUS_NUMBER("보너스 번호를 입력해 주세요.\n"),
	RESULT_TITLE("당첨 통계\n---\n"),
	RESULT("%d개 일치 (%,d원) - %d개\n"),
	RESULT_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
	RESULT_RATE("총 수익률은 %,.1f%%입니다.")
	;

	private final String message;

	private Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
