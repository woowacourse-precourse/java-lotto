package util;

public enum LottoStatus {
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    LOTTO_SIZE(6),
    WIN_COUNT(5);
    private final int code;

    LottoStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
