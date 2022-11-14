package lotto;

public enum Exceptions {
    ERROR_MESSAGE("[ERROR]"),
    NON_AVAILABLE_AMOUNT("금액이 잘못 입력되었습니다."),
    NOT_DIVIDED("1000으로 나눠떨이지지 않습니다."),
    NEGATIVE_AMOUNT("금액은 음수가 될 수 없습니다."),
    NOT_6_ELEMENT("로도 번호는 6개만 입력 가능합니다."),
    NOT_IN_SCALE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ILLEGAL_INPUT("잘못된 입력입니다.");

    String msg;

    Exceptions(String msg) {
        this.msg = msg;
    }
}
