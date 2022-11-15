package lotto.domain;

public enum Rank {
    FIRST(0, 2000000000, 6, 0),
    SECOND(0, 30000000, 5, 1),
    THIRD(0, 1500000, 5, 0),
    FOURTH(0, 50000, 4, 0),
    FIFTH(0, 5000, 3, 0);

    private int count;
    private final int money;
    private final int win;
    private final int bonusWin;

    Rank(int count, int money, int win, int bonusWin) {
        this.count = count;
        this.money = money;
        this.win = win;
        this.bonusWin = bonusWin;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public int getWin() {
        return win;
    }

    public int getBonusWin() {
        return bonusWin;
    }

    public void plusCount() {
        count++;
    }

}
