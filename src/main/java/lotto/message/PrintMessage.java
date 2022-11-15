package lotto.message;

public enum PrintMessage {
    MESSAGE_STATISTICS("당첨 통계"),
    MESSAGE_LINE("---"),
    MESSAGE_FIRST("6개 일치 (%,d원) - %,d개\n"),
    MESSAGE_SECOND("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    MESSAGE_THIRD("5개 일치 (%,d원) - %,d개\n"),
    MESSAGE_FOURTH("4개 일치 (%,d원) - %,d개\n"),
    MESSAGE_FIFTH("3개 일치 (%,d원) - %,d개\n"),
    MESSAGE_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.\n"),
    MESSAGE_ENTER_PRICE("금액을 입력해 주세요."),
    MESSAGE_BUY_LOTTO("%d개를 구매했습니다.\n"),
    MESSAGE_ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    MESSAGE_ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
