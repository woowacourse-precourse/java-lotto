package lotto;

public enum LottoWinType {
    FIRST_PLACE(6, 0, 2000000000),
    SECOND_PLACE(5, 1, 30000000),
    THIRD_PLACE(5, 0, 1500000),
    FOURTH_PLACE(4, 0, 50000),
    FIFTH_PLACE(3, 0, 5000);

    private int corretAnswer;
    private int correntBonus;
    private int money;

    LottoWinType(int corretAnswer, int correntBonus, int money) {
        this.corretAnswer = corretAnswer;
        this.correntBonus = correntBonus;
        this.money = money;
    }

    public int getCorretAnswer() {
        return corretAnswer;
    }

    public int getCorrentBonus() {
        return correntBonus;
    }

    public int getMoney() {
        return money;
    }
}
