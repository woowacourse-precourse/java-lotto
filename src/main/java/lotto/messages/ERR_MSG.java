package lotto.messages;

public enum ERR_MSG {

    INVALID_LENGTH("[ERROR] 로또 번호의 개수에 오류가 있습니다."),
    INVALID_NUMBER_UNIQUE("[ERROR] 로또 번호에 중복된 숫자가 포함되어 있습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 숫자 범위에 오류가 있습니다. 숫자 범위는 1에서 45 입니다."),

    INVALID_PURCHASE_AMOUNT("[ERROR] 구매금액은 1000원 단위의 숫자만 입력 가능합니다."),



    ERR_WINNING("[ERROR] 당첨번호는 6개 숫자를 콤마(,)로 구분하여 입력해 주세요."),
    ERR_NOT_UNIQUE_NUM("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    ERR_NUMBER_FORMAT("[ERROR] 문자를 입력할 수 없습니다."),
    ERR_NUMBER_RANGE("[ERROR] 입력가능한 숫자의 범위는 1~45입니다.");

    private final String msg;

    ERR_MSG(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
