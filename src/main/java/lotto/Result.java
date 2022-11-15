package lotto;

public enum Result {

    FIRST(6, false, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, "4개 일치 (50,000원) - "),
    FIFTH(3, false, "3개 일치 (5,000원) - ");

    private final int equalCount;
    private final boolean isBonus;
    private final String message;

    Result(int equalCount, boolean isBonus, String message) {
        this.equalCount = equalCount;
        this.isBonus = isBonus;
        this.message = message;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public boolean getIsBonus() {
        return isBonus;
    }

    public String getMessage() {
        return message;
    }
}
