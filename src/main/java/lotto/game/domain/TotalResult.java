package lotto.game.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalResult {
    private final Map<LottoGrade, Integer> totalWinnings;

    private TotalResult(Map<LottoGrade, Integer> totalWinnings) {
        this.totalWinnings = totalWinnings;
    }

    public static TotalResult of(List<LottoGrade> grades) {
        Map<LottoGrade, Integer> totalWinnings = new HashMap<>();
        for (LottoGrade grade : grades) {
            addWinning(totalWinnings, grade);
        }
        return new TotalResult(totalWinnings);
    }

    private static void addWinning(Map<LottoGrade, Integer> totalWinnings, LottoGrade grade) {
        if (totalWinnings.containsKey(grade)) {
            totalWinnings.put(grade, totalWinnings.get(grade) + 1);
            return;
        }
        totalWinnings.put(grade, 1);
    }

    public Integer getCount(LottoGrade grade) {
        return totalWinnings.getOrDefault(grade, 0);
    }
}
