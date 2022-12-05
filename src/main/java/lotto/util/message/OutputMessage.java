package lotto.util.message;

public enum OutputMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_LOTTO("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    OUTPUT_MY_LOTTO("%d개를 구매했습니다.%n"),
    OUTPUT_RESULT_MESSAGE("%n당첨 통계%n---"),
    OUTPUT_RESULT_PART1("%n%d개 일치"),
    OUTPUT_RESULT_BONUS(", 보너스 볼 일치"),
    OUTPUT_RESULT_PART2(" (%s원) - %d개"),
    OUTPUT_RATE("%n총 수익률은 %,.1f%%입니다.");

    private final String value;

    OutputMessage(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
