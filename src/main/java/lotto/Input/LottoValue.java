package lotto.Input;

public enum LottoValue {
    MIN(1),
    MAX(45),
    SIZE(6);
    private final int num;

    LottoValue(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

}
