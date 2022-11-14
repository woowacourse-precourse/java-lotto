package domain;

import java.util.Arrays;
import java.util.List;

/**
 * 가능한 로또 등수 정보를 관리하는 Enum
 */
public enum LottoGrade {
    FIRST(1, 6, 2_000_000_000, false),
    SECOND(2, 5, 30_000_000, true),
    THIRD(3, 5, 1_500_000, false),
    FOURTH(4, 4, 50_000, null),
    FIFTH(5, 3, 5_000, null),
    FAIL(6, 0, 0, null);
    public final int grade;
    public final int matchNumberCount;
    public final int prize;
    public final Boolean hasBonusNumber;

    LottoGrade(int grade, int matchNumberCount, int prize, Boolean hasBonusNumber) {
        this.grade = grade;
        this.matchNumberCount = matchNumberCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoGrade getMatchGrade(int matchNumberCount, boolean hasBonusNumber) {
        return Arrays.stream(LottoGrade.values()).filter((grade) -> grade.matchNumberCount == matchNumberCount)
                .filter((grade) -> grade.hasBonusNumber == null || grade.hasBonusNumber == hasBonusNumber).findFirst().orElse(FAIL);
    }

    public static List<LottoGrade> getLottoGradesWithoutFail(){
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }
}
