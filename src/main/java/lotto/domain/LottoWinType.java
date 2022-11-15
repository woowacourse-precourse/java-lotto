package lotto.domain;

public enum LottoWinType {
    
    FIRST(6, 0, 2000000000, 4),
    SECOND(5, 1, 30000000, 3),
    THIRD(5, 0, 1500000, 2),
    FOURTH(4, 0, 50000, 1),
    FIFTH(3, 0, 5000, 0),
    ELSE(0, 0, 0, 0);

    private int correctAnswer;
    private int correctBonus;
    private int money;
    private int index;

    LottoWinType(int correctAnswer, int correctBonus, int money, int index) {
        this.correctAnswer = correctAnswer;
        this.correctBonus = correctBonus;
        this.money = money;
        this.index = index;
    }

    public int getMoney() {
        return money;
    }

    public int getIndex() {
        return index;
    }

    public static LottoWinType matchGameScoreAndLottoWinType(int answer, int bonus) {
        if (answer == 6) {
            return LottoWinType.FIRST;
        }
        if (answer == 5 && bonus == 1) {
            return LottoWinType.SECOND;
        }
        if (answer == 5 && bonus == 0) {
            return LottoWinType.THIRD;
        }
        if (answer == 4) {
            return LottoWinType.FOURTH;
        }
        if (answer == 3) {
            return LottoWinType.FIFTH;
        }
        return LottoWinType.ELSE;
    }
}
