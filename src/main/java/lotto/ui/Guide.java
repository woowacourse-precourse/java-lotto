package lotto.ui;

public enum Guide {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---");

    private final String message;

    Guide(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }
}
