package lotto;

public enum Initialize {
    AMOUNT("구입금액을 입력해 주세요."),
    LOTTO("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    PURCHASE("개를 구매했습니다.");

    private final String message;

    Initialize(String s) {
        this.message = s;
    }

    public String message() {
        return message;
    }
}
