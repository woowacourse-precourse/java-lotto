package lotto.view;

public enum Messages {
    REQUEST_BUDGET_INPUT("구입금액을 입력해 주세요."),
    PURCHASED_TICKET_COUNTS("\n%d개를 구매했습니다.\n"),
    REQUEST_WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_INPUT("\n보너스 번호를 입력해 주세요."),
    LOTTO_RESULT("%d개 일치 (%s원) - %d개\n"),
    LOTTO_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    LOTTO_PROFIT("총 수익률은 %s%%입니다.\n");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
