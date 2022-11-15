package lotto.common;

public enum Error {
    NUMBER("[ERROR] 숫자여야 합니다."),
    THOUSAND("[ERROR] 천원단위여야 합니다."),
    MINUS("[ERROR] 최소 천원이어야 합니다."),
    FORMAT("[ERROR] 6글자여야 합니다."),
    SIZE("[ERROR] 1에서 45사이여야 합니다."),
    DUPLICATE("[ERROR] 중복된 숫자가 있으면 안됩니다.");
    private String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
