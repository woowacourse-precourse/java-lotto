package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amount {
    public static final int THREE_HIT = 3;
    public static final int FOUR_HIT = 4;
    public static final int FIVE_HIT = 5;
    public static final int SIX_HIT = 6;

    enum grade {first, second, third, fourth, fifth,lose}

    private final List<grade> winning_amount = Arrays.asList(grade.first, grade.second, grade.third, grade.fourth, grade.fifth);

    public static grade getGrade(int hitCount, boolean bonus_hit) {
        if (hitCount == THREE_HIT) return grade.fifth;
        if (hitCount == FOUR_HIT) return grade.fourth;
        if (hitCount == FIVE_HIT && !bonus_hit) return grade.third;
        if (hitCount == FIVE_HIT && bonus_hit) return grade.second;
        if (hitCount == SIX_HIT) return grade.first;
        else return grade.lose;

    }
}
