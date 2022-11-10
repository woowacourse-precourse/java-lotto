package lotto.entity;

public enum Guide {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASING_QUANTITY("\n%d개를 구매했습니다."),
    WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),

    WINNING_DETAILS("\n당첨 통계\n" + "---"),
    WINNING_DETAILS_ARGUMENT("(%,d원) - %d개"),

    EARNING_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    private Guide(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
