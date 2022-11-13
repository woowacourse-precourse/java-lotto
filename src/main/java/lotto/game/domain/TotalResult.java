package lotto.game.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

public class TotalResult {
    private final Map<LottoGrade, Long> totalWinnings;

    private TotalResult(Map<LottoGrade, Long> totalWinnings) {
        this.totalWinnings = totalWinnings;
    }

    public static TotalResult of(List<LottoGrade> grades) {
        Map<LottoGrade, Long> collect = grades.stream()
                .collect(groupingBy(grade -> grade, counting()));
        return new TotalResult(collect);
    }

    public Long getCount(LottoGrade grade) {
        return totalWinnings.getOrDefault(grade, 0L);
    }
}
