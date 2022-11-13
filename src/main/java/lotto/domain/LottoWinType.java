package lotto.domain;

public enum LottoWinType {
    FIRST_PLACE(6, 0, 2000000000, 4),
    SECOND_PLACE(5, 1, 30000000, 3),
    THIRD_PLACE(5, 0, 1500000, 2),
    FOURTH_PLACE(4, 0, 50000, 1),
    FIFTH_PLACE(3, 0, 5000, 0),
    ELSE(0, 0, 0, 0);

    private int corretAnswer;
    private int correntBonus;
    private int money;
    private int idx;

    LottoWinType(int corretAnswer, int correntBonus, int money, int idx) {
        this.corretAnswer = corretAnswer;
        this.correntBonus = correntBonus;
        this.money = money;
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
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

    public static LottoWinType matchGameScoreAndLottoWinType(int answer, int bonus) {
        if (answer == 6) {
            return LottoWinType.FIRST_PLACE;
        }
        if (answer == 5 && bonus == 1) {
            return LottoWinType.SECOND_PLACE;
        }
        if (answer == 5 && bonus == 0) {
            return LottoWinType.THIRD_PLACE;
        }
        if (answer == 4) {
            return LottoWinType.FOURTH_PLACE;
        }
        if (answer == 3) {
            return LottoWinType.FIFTH_PLACE;
        }
        return LottoWinType.ELSE;
    }
}
