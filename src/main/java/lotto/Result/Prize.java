package lotto.Result;

public enum Prize {
    FIFTH(30,5000, "3개 일치 (5,000원)"),
    FOURTH(40,50000,"4개 일치 (50,000원)"),
    THIRD(50,1500000,"5개 일치 (1,500,000원)"),
    SECOND(51,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(60,2000000000,"6개 일치 (2,000,000,000원)");

    private int count;
    private Integer prize;
    private String message;

    Prize(int count, Integer prize, String message) {
        this.count = count;
        this.prize = prize;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public Integer getPrize() {
        return prize;
    }
}