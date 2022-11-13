package lotto.constant;

public enum OutputConstants {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    PURCHASE_QUANTITY("%d개를 구매했습니다."),

    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    STATISTICS("당첨통계\n---"),
    FIFTH_PLACE("3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE("4개 일치 (50,000원) - %d개"),
    THIRD_PLACE("5개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - %d개"),
    PROFIT_RATE("총 수익률은 %.1f%입니다.");

    private final String message;

    OutputConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
