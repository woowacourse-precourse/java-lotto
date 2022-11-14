package lotto;

public enum Rank {
    FIFTH_PLACE(5, 5000, "3개 일치"),
    FOURTH_PLACE(4, 50000, "4개 일치"),
    THIRD_PLACE(3, 1500000, "5개 일치"),
    SECOND_PLACE(2, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST_PLACE(1, 2000000000, "6개 일치");

    private final int place;
    private final int prize;
    private final String condition;

    private Rank(int place, int prize, String condition) {
        this.place = place;
        this.prize = prize;
        this.condition = condition;
    }

    public int getPrize() {
        return prize;
    }

    public int getPlace() {
        return place;
    }

    public String getCondition() {
        return condition;
    }
}
