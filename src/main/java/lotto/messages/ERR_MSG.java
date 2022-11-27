package lotto.messages;

public enum ERR_MSG {

    INVALID_LENGTH("[ERROR] 로또 번호의 개수 오류 발생"),
    INVALID_NUMBER_UNIQUE("[ERROR] 중복된 숫자가 포함되어 있습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 숫자 범위는 1에서 45까지 가능합니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구매 금액은 1000원 단위로 입력해 주세요."),
    INVALID_WINNING_NUMBER("[ERROR] 당첨번호는 1에서 45 범위의 6개 숫자를 콤마(,)로 구분하여 입력해 주세요.");

    private final String msg;

    ERR_MSG(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
