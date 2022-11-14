package lotto.userinterface;

public enum Hit {
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 15_000_000),
    FIVE_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000);

    private Integer prize;
    private Integer hitCount;
    private Boolean bonus;

    Hit(Integer hitCount, Boolean bonus, Integer prize) {
        this.hitCount = hitCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public Integer getPrize() {
        return prize;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public static Hit getHit(Integer hitCount, Boolean bonus) {
        for (Hit hit : Hit.values()) {
            if (hit.hitCount == hitCount && hit.bonus == bonus) {
                return hit;
            }
        }

        return null;
    }
}
