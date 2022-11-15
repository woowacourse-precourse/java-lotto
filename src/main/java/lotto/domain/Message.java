package lotto.domain;


public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요.\n"),
    INPUT_WIN_LOTTONUMBER("당첨 번호를 입력해 주세요.\n"),
    MONEY_CANT_DIVIED_BY_1000("[ERROR] 구매 금액이 1000단위가 아닙니다."),
    MONEY_IS_LOWER_THAN_1000("[ERROR] 구매 금액이 1000보다 작습니다."),
    LOTTO_NUMMBER_ERROR("[ERROR] 정수가 아닌 수가 입력되었습니다.");

    private String message;

    public String get() {
        return message;
    }

    Message(String message) {
        this.message = message;
    }
}
