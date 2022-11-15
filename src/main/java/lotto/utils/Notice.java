package lotto.utils;

public enum Notice {
    LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    NUMBER_OF_LOTTO("%d개를 구매했습니다."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_OF_WINNING_LOTTO("당첨 통계\n" + "---"),
    EARNINGS_RATE("총 수익률은 %s입니다.");

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int number) {
        return String.format(message, number);
    }

}
