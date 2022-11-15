package lotto;

public enum Result {

    FIFTH(3, "3개 일치 (5,000원) - "),
    FOURTH(4, "4개 일치 (50,000원) - "),
    THIRD(5, "5개 일치 (1,500,000원) - "),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, "6개 일치 (2,000,000,000원) - "),
    NO_REWARD(0, "");

    private final int equalCount;
    private final String message;

    Result(int equalCount, String message) {
        this.equalCount = equalCount;
        this.message = message;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public String getMessage() {
        return message;
    }
}
