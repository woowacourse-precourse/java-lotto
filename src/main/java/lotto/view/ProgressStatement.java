package lotto.view;

public enum ProgressStatement {
	PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
	PURCHASE_DETAILS("개를 구매했습니다."),
	WINNING_NUMBER("\n" + "당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("\n" + "보너스 번호를 입력해 주세요."),
	WINNING_STATISTICS("\n" + "당첨 통계" + System.lineSeparator() + "---"),
	START_GROSS_PROFIT("총 수익률은 "),
	END_GROSS_PROFIT("%입니다.");

	private final String progress;

	ProgressStatement(String progress) {
		this.progress = progress;
	}

	public String getProgress() {
		return progress;
	}
}
