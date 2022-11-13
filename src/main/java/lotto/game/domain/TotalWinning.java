package lotto.game.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalWinning {
    private final Map<LottoGrade, Integer> lottoGrades;

    private TotalWinning(Map<LottoGrade, Integer> totalWinnings) {
        this.lottoGrades = totalWinnings;
    }

    public static TotalWinning of(List<LottoGrade> grades) {
        Map<LottoGrade, Integer> totalWinnings = new HashMap<>();
        for (LottoGrade grade : grades) {
            addWinning(totalWinnings, grade);
        }
        return new TotalWinning(totalWinnings);
    }

    private static void addWinning(Map<LottoGrade, Integer> totalWinnings, LottoGrade grade) {
        if (totalWinnings.containsKey(grade)) {
            totalWinnings.put(grade, totalWinnings.get(grade) + 1);
            return;
        }
        totalWinnings.put(grade, 1);
    }

    public Integer getCount(LottoGrade grade) {
        return lottoGrades.getOrDefault(grade, 0);
    }
}
