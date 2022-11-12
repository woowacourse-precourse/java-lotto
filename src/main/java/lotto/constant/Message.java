package lotto.constant;

public enum Message {
	ASKING_PURCHASING_AMOUNT("구입금액을 입력해 주세요."),
	DISPLAYING_PURCHASING_QUANTITY("%d개를 구매했습니다."),
	ASKING_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
	ASKING_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	WINNING_STATISTICS_BEGINNING("당첨 통계"),
	DIVISION_LINE("---"),
	COUNTING_PRIZE_WITHOUT_BONUS("%d개 일치 (%s원) - %d개"),
	COUNTING_PRIZE_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
	DISPLAYING_RATE_OF_PROFIT("총 수익률은 %f%입니다.");
	private final String message;
	Message(String message) {
		this.message = message;
	}

	public String message() {
		return message;
	}
}
