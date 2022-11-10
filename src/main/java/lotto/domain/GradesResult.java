package lotto.domain;

import java.util.Map;

public class GradesResult {

    private final Map<Grade, Integer> gradeResult;

    public GradesResult(Map<Grade, Integer> gradeResult) {
        this.gradeResult = gradeResult;
    }
}
