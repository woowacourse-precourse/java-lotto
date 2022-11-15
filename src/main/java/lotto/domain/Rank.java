package lotto.domain;

public enum Rank {
    FIRST_PLACE("1등", 2000000000, "6개 일치"),
    SECOND_PLACE("2등", 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD_PLACE("3등", 1500000, "5개 일치"),
    FOURTH_PLACE("4등", 50000, "4개 일치"),
    FIFTH_PLACE("5등", 5000, "3개 일치"),
    NO_PLACE("6등 이하", 0, "2개 이하 일치")
    ;

    private final String title;
    private final int place;
    private int profit;
    private final String detail;

    Rank(String title, int profit, String detail) {
        this.title = title;
        this.place = title.charAt(0) -0;
        this.profit = profit;
        this.detail = detail;
    }

    public String getTitle() { return title; }

    public int getPlace() { return place; }

    public int getProfit() { return profit; }

    public String getdetail() { return detail; }
}
