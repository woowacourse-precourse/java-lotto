package lotto.ui;

public enum Messages {
    INPUT_MONEY("구입금액을 입력해 주세요"),
    INPUT_LOTTE_NUMBER("당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요"),
    OUTPUT_USER_LOTTO("개를 구매했습니다."),
    OUTPUT_LOTTO_RESULT("당첨 통계\n" + "---\n");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
