package lotto.enums;

import java.util.Arrays;

public enum WinCondition {
    FIRST(6, 0, 4),
    SECOND(5, 1, 3),
    THIRD(5, 0, 2),
    FOURTH(4,0, 1),
    FIFTH(3,0, 0);
    private Integer normal_count;
    private Integer bonus_count;
    private Integer index;
    private WinCondition(Integer normal, Integer bonus, Integer index){
        this.normal_count = normal;
        this.bonus_count = bonus;
        this.index = index;
    }

    public static Integer getIndex(Integer normal, Integer bonus){
        return Arrays.stream(WinCondition.values())
                .filter(i -> i.normal_count == normal && i.bonus_count == bonus)
                .findAny()
                .map(i -> i.index)
                .orElse(-1);
    }

    public Integer getNormal_count(){
        return normal_count;
    }
    public Integer getBonus_count(){
        return bonus_count;
    }
}
