package lotto.domain;

public enum Rank {
    FIRST_PLACE("1등", 1, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND_PLACE("2등", 2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PLACE("3등", 3, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH_PLACE("4등", 4, 50000, "4개 일치 (50,000원) - "),
    FIFTH_PLACE("5등", 5, 5000, "3개 일치 (5,000원) - "),
    NO_PLACE("6등 이하", 6, 0, "2개 이하 일치 - ")
    ;

    private final String title;
    private final int place;
    private int profit;
    private final String detail;

    Rank(String title, int place, int profit, String detail) {
        this.title = title;
        this.place = place;
        this.profit = profit;
        this.detail = detail;
    }

    public String getTitle() { return title; }

    public int getPlace() { return place; }

    public int getProfit(int place) {
        if (place == 1) {
            return FIRST_PLACE.profit;
        } else if (place == 2) {
            return SECOND_PLACE.profit;
        } else if (place == 3) {
            return THIRD_PLACE.profit;
        } else if (place == 4) {
            return FOURTH_PLACE.profit;
        } else if (place == 5) {
            return FIFTH_PLACE.profit;
        } return 0;
    }

    public String getdetail() { return detail; }
}
