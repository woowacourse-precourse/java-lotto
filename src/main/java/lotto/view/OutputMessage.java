package lotto.view;

public enum OutputMessage {
    INPUT_PAID_AMOUNT("구입금액을 입력해 주세요."),
    INFO_LOTTO_COUNT("\n%d개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    OUTPUT_STATS_MESSAGE("\n당첨 통계\n---"),
    OUTPUT_YIELD_PERCENT("총 수익률은 %.1f%%입니다.");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
	this.outputMessage = outputMessage;
    }

    public String getValue() {
	return outputMessage;
    }
}
