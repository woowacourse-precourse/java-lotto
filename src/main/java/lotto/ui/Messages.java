package lotto.ui;

public enum Messages {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."), NUMBER_OF_PURCHASE("%d개를 구매했습니다."), WINNING_NUMBER(
            "당첨 번호를 입력해 주세요."), BONUS_NUMBER("보너스 번호를 입력해 주세요."), WINNING_STATISTICS("당첨 통계\n---"), RATE_OF_RETURN(
                    "총 수익률은 %.1f%%입니다."), WINNING_COUNT(
                            "%d개 일치 (%s원) - %d개"), WINNING_COUNT_FOR_BONUS("5개 일치, 보너스 볼 일치 (%s원) - %d개");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
