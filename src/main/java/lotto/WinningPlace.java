package lotto;

public enum WinningPlace {
    FIRST_PLACE(2000000000,"6개 번호 일치"),
    SECOND_PLACE(30000000,"5개 번호 + 보너스 번호 일치"),
    THIRD_PLACE(1500000,"5개 번호 일치"),
    FOURTH_PLACE(50000,"4개 번호 일치"),
    FIFTH_PLACE(5000,"3개 번호 일치");

    private Integer winnings;
    private String message;

    public Integer getWinnings() {
        return this.winnings;
    }

    public String getMessage() {
        return this.message;
    }

    WinningPlace(Integer winnings, String message) {
        this.winnings = winnings;
        this.message = message;
    }
}
