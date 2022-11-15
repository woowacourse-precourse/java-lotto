package lotto;

import static lotto.Error.EQUAL_COUNT_ERROR;

public enum Result {

    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    NO_REWARD(0, false, 0, "");

    private final int equalCount;
    private boolean isBonus;
    private final int reward;
    private final String message;

    Result(int equalCount, boolean isBonus, int reward, String message) {
        this.equalCount = equalCount;
        this.isBonus = isBonus;
        this.reward = reward;
        this.message = message;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }

    public static Result getMatchResult(int equalCount, boolean isBonus) {
        if (equalCount < 3) {
            return NO_REWARD;
        }

        for (Result result : values()) {
            if (result.equalCount == equalCount && result.isBonus == isBonus) {
                return result;
            }
        }

        throw new IllegalArgumentException(EQUAL_COUNT_ERROR.getMessage());
    }
}
