package lotto.resource.message;

public enum PrintMessage {
    PAYOUT("구입금액을 입력해 주세요."),
    LOTTO_COUNT("%d개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    STATISTICS_NONE_BONUS("%d개 일치 (%s원) - %d개"),
    STATISTICS_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    TOTAL_RETURN("총 수익률은 %,.1f%%입니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
