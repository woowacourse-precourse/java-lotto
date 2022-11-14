package domain;

import Service.gradeService;

import java.util.Arrays;
import java.util.List;

public class Grade {
    public static final int THREE_HIT = 3;
    public static final int FOUR_HIT = 4;
    public static final int FIVE_HIT = 5;
    public static final int SIX_HIT = 6;

    public enum Lottogrades {first, second, third, fourth, fifth, lose}

    public static Lottogrades getGrade(int hitCount, boolean bonus_hit) {

        if (hitCount == THREE_HIT) return Lottogrades.fifth;
        if (hitCount == FOUR_HIT) return Lottogrades.fourth;
        if (hitCount == FIVE_HIT && !bonus_hit) return Lottogrades.third;
        if (hitCount == FIVE_HIT && bonus_hit) return Lottogrades.second;
        if (hitCount == SIX_HIT) return Lottogrades.first;

        return Lottogrades.lose;

    }
}
