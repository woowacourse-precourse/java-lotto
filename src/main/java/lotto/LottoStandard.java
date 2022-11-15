package lotto;

public enum LottoStandard {
    CORRECT3(0, 5000),
    CORRECT4(1, 50000),
    CORRECT5(2, 1500000),
    CORRECT5_bonus(3, 30000000),
    CORRECT6(4, 2000000000);

    private final int index;
    private final int vlaue;

    private LottoStandard(int index, int value)
    {
        this.index = index;
        this.vlaue = value;
    }

    public int getIndex()
    {
        return this.index;
    }

    public int getVlaue()
    {
        return this.vlaue;
    }

}
