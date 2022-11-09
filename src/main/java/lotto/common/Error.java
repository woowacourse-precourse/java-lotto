package lotto.common;

public enum Error {
    WELCOME("구입금액을 입력해 주세요."),
    NUMBER("[ERROR] 구매금액은 숫자여야 합니다."),
    THOUSAND("[ERROR] 구매금액은 천원단위여야 합니다.");;
    private String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
