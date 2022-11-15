package lotto;

public enum OutputMessage {
    PRICE("구입금액을 입력해 주세요."),
    AMOUNT("개를 구매했습니다."),
    WIN("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    STATISTICS("당첨 통계\n---");



    String message;
    private OutputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
