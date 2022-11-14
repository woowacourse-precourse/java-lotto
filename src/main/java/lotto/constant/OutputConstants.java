package lotto.constant;

public enum OutputConstants {

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_QUANTITY("%d개를 구매했습니다."),

    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    STATISTICS("당첨통계\n---"),
    PROFIT_RATE("총 수익률은 %.1f%입니다.");

    private final String message;

    OutputConstants(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
