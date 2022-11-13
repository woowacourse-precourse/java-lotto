package lotto.constant;

public enum UserOutputMessage {
    POSTFIX_NUMBER_OF_PURCHASES("개를 구매했습니다."),
    PREFIX_WINNING_RESULT("당첨 통계\n" + "---"),
    WINNING_RESULT("%d개 일치 (%s원) - %s개\n"),
    WINNIGN_RESULT_WITH_BONUS_MATCHES("%d개 일치, 보너스 볼 일치 (%s원) - %s개\n"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    UserOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
