package lotto;

public enum Hit {
    THREE(3, false, "5,000"),
    FOUR(4, false, "50,000"),
    FIVE(5, false, "1,500,000"),
    FIVE_BONUS(5, true, "30,000,000"),
    SIX(6, false, "2,000,000,000");

    private String prize;
    private Integer hitCount;
    private Boolean bonus;

    Hit(Integer hitCount, Boolean bonus, String prize) {
        this.hitCount = hitCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public String getPrize() {
        return prize;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public Boolean requireBonus() {
        return bonus;
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