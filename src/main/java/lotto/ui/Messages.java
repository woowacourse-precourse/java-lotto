package lotto.ui;

public enum Messages {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."), NUMBER_OF_PURCHASE("개를 구매했습니다."), WINNING_NUMBER(
            "당첨 번호를 입력해 주세요."), BONUS_NUMBER("보너스 번호를 입력해 주세요."), WINNING_STATISTICS(
                    "당첨 통계\n---"), RATE_OF_RETURN("총 수익률은 %s 입니다."), WINNING_COUNT("%d개 일치 (%d원)- %d개");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

}
