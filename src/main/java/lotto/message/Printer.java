package lotto.message;

public enum Printer {
    START("구입금액을 입력해 주세요."),
    WIN_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n" + "---\n");


    private String message;

    Printer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
