package lotto.domain;

public enum Correct {
    THREE(0), FOUR(0), FIVE(0), FIVE_BONUS(0), SIX(0), NOTHING(0);

    private int cnt;
    Correct(int cnt) {
        this.cnt = cnt;
    }
    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
