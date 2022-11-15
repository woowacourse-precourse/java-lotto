package lotto;

import java.util.Arrays;

public enum Hit {
    FIRST_PRIZE("6", "0", 0),
    SECOND_PRIZE("5", "1", 1),
    THIRD_PRIZE1("5", "0", 2),
    THIRD_PRIZE2("4", "1", 2),
    FOURTH_PRIZE1("4", "0", 3),
    FOURTH_PRIZE2("3", "1", 3),
    FIFTH_PRIZE1("3", "0", 4),
    FIFTH_PRIZE2("2", "1", 4);

    private final String hit;
    private final String bonus;
    private final Integer result;

    Hit(String hit, String bonus, Integer result) {
        this.hit = hit;
        this.bonus = bonus;
        this.result = result;
    }

    public static Integer valueOfLabel(String hit, String bonus) {
        Hit prize = Arrays.stream(values())
                .filter(value -> value.hit.equals(hit))
                .filter(value -> value.bonus.equals(bonus))
                .findAny()
                .orElse(null);
        if (prize == null) {
            return null;
        }
        return prize.result;
    }
}
