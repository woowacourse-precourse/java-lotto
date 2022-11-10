package lotto.entity;

public enum Guide {
    PURCHASING_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    WINNING_DETAILS("당첨 통계\n" + "---"),
    WINNING_DETAILS_ARGUMENT("(%,d) - %d개"),

    EARNING_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    private Guide(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
