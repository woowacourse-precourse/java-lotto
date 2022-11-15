package lotto.domain;


public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요.\n"),
    INPUT_WIN_LOTTONUMBER("당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_LOTTONUMBER("보너스 번호를 입력해 주세요.\n"),
    MONEY_CANT_DIVIED_BY_1000("[ERROR] 구매 금액이 1000단위가 아닙니다."),
    MONEY_IS_LOWER_THAN_1000("[ERROR] 구매 금액이 1000보다 작습니다."),
    NUMBER_CONTAINS_ALPABET("[ERROR]"),
    LOTTO_NUMMBER_ERROR("[ERROR] 정수가 아닌 수가 입력되었습니다."),
    BONUS_NUMBER_ISNOT_NUM_ERROR("[ERROR] 보너스 번호가 정수가 아닙니다."),
    BONUS_NUM_RANGE_ERROR("[ERROR] 보너스 번호 범위가 1과 45사이가 아닙니다."),
    LOTTO_NUM_RANGE_ERROR("[ERROR] 로또 번호가 1과 45사이가 아닙니다."),
    BONUS_NUM_DUPLICATE_ERROR("[ERROR] 보너스 번호와 당첨번호가 중복됩니다."),
    LOTTO_NUM_DUPLICATE_ERROR("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");

    private String message;

    public String get() {
        return message;
    }

    Message(String message) {
        this.message = message;
    }
}
