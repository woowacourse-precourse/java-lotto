package lotto.view;

// 입출력 나눠서 진행할지
public enum ProgressStatement {
	PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
	PURCHASE_DETAILS("8개를 구매했습니다."),
	WINNING_NUMBER("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	WINNING_STATISTICS("당첨 통계");

	private final String progress;

	ProgressStatement(String progress) {
		this.progress = progress;
	}

	public String getProgress() {
		return progress;
	}
}
