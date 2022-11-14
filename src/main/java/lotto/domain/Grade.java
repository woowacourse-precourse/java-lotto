package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public enum Grade {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    private static final DecimalFormat format = new DecimalFormat("###,###");

    private final int count;
    private final int prizeMoney;

    Grade(int count, int prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Grade getGrade(int count, boolean haveBonusNumber) {
        if (count == 5 && haveBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(Grade.values())
                     .filter(grade -> grade != SECOND)
                     .filter(grade -> grade.count == count)
                     .findFirst()
                     .orElse(null);
    }

    public static Map<Grade, Integer> getAllGrades() {
        Map<Grade, Integer> grades = new TreeMap<>(Comparator.comparing(Grade::getPrizeMoney));

        for (Grade grade : Grade.values()) {
            grades.put(grade, 0);
        }

        return grades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(count).append("개 일치");
        if (this == SECOND) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(format(prizeMoney)).append("원)");

        return sb.toString();
    }

    private String format(int money) {
        return format.format(money);
    }

}
