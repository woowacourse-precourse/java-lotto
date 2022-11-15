package lotto.model;

public enum TypeWinning {
    THREE(0),
    FOUR(1),
    FIVE(2),
    FIVE_BONUS(3),
    SIX(4);
    private int table1Value;
    TypeWinning(int table1Value) {
        this.table1Value = table1Value;
    }
    public int getTable1Value() {
            return table1Value;
        }
}

