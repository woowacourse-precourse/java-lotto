package lotto.Enum;

public enum LottoInfo {
    START(1),
    END(45),
    COUNT(6);

    private final int info;
    LottoInfo(final int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }
}
