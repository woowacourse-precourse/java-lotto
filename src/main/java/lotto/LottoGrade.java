package lotto;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 가능한 로또 등수 정보를 관리하는 Enum
 */
public enum LottoGrade {
    FIRST(1, 6, 2_000_000_000, false),
    SECOND(2, 5, 30_000_000, true),
    THIRD(3, 5, 1_500_000, false),
    FOURTH(4, 4, 50_000, false),
    FIFTH(5, 3, 5_000, false),
    FAIL(6, 0, 0, false);

    private final int grade;
    private final int matchNumberCount;
    private final int prize;
    private final boolean matchBonus;

    LottoGrade(int grade, int matchNumberCount, int prize, boolean matchBonus) {
        this.grade = grade;
        this.matchNumberCount = matchNumberCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static LottoGrade getMatchGrade(int matchNumberCount, boolean matchBonus) {
        return Arrays.stream(LottoGrade.values()).filter((grade) -> grade.matchBonus == matchBonus)
                .filter((grade) -> grade.matchNumberCount == matchNumberCount).findFirst().orElse(FAIL);
    }
}
