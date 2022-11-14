package lotto.ui;

public enum Messages {
    INPUT_MONEY("구입금액을 입력해 주세요"),
    INPUT_LOTTE_NUMBER("\n당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요"),
    LOTTO_AMOUNT("개를 구매했습니다."),
    LOTTO_RESULT("\n당첨 통계\n" + "---\n"),
    LOTTO_PERCENT_HEAD("총 수익률은 "),
    LOTTO_PERCENT_TAIL("%입니다.");

    private String message;

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
