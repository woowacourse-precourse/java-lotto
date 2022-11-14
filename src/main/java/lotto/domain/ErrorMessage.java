package lotto.domain;

public enum ErrorMessage {
    PREFIX("[ERROR] "),

    NOT_A_NUMBER("숫자를 입력하세요"),
    INVALID_MONEY("천 단위 이상의 숫자를 입력하세요"),
    INVALID_LOTTO_NUMBER("','로 구분된 6개의 수를 입력하세요(1~45)"),
    INVALID_BONUS_NUMBER("로또 숫자와 중복되지 않는 수를 입력하세요(1~45)");

    private final String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
