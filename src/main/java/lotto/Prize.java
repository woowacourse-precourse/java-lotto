package lotto;

public enum Prize {
    FIFTH("5등", 5_000),
    FOURTH("4등", 50_000),
    THIRD("3등", 1_500_000),
    SECOND("2등", 30_000_000),
    FIRST("1등", 2_000_000_000),
    LAST("꼴등", 0);

    private final int prize;
    private final String place;

    private Prize(String place, int prize) {
        this.place = place;
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getPlace() {
        return this.place;
    }
}