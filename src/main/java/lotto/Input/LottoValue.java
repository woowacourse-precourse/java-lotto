package lotto.Input;

public enum LottoValue {
    MIN(1),
    MAX(45),
    SIZE_No_Bonus(6),
    SIZE_YES_BONUS(7);

    private final int num;

    LottoValue(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

}
