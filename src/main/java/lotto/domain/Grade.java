package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Grade {
    FIFTH("3개 일치 (5,000원) - ", Arrays.asList(0)),
    FOURTH("4개 일치 (50,000원) - ", Arrays.asList(1)),
    THIRD("5개 일치 (1,500,000원) - ", Arrays.asList(2)),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", Arrays.asList(4)),
    FIRST("6개 일치 (2,000,000,000원) - ", Arrays.asList(3));

    private final String name;
    private final List<Integer> grade;
    Grade(String name, List<Integer> grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGradeCount() {
        return grade.get(0);
    }

}
