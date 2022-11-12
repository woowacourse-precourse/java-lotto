package lotto;

public enum Message {

    START("구입금액을 입력해 주세요."),
    TOTAL("개를 구매했습니다."),
    INPUT("당첨 번호를 입력해 주세요. "),
    BONUS("보너스 번호를 입력해 주세요. "),
    STATISTICS("당첨 통계 ");

    private final String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
