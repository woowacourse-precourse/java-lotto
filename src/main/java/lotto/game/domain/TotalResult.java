package lotto.game.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalResult {
    private final Map<LottoGrade, Integer> totalWinnings;
    private final Money totalProfit;

    private TotalResult(Map<LottoGrade, Integer> totalWinnings, Money totalProfit) {
        this.totalWinnings = totalWinnings;
        this.totalProfit = totalProfit;
    }

    public static TotalResult of(List<LottoGrade> grades) {
        Map<LottoGrade, Integer> totalWinnings = new HashMap<>();
        for (LottoGrade grade : grades) {
            addWinning(totalWinnings, grade);
        }
        Money totalProfit = calculateTotalProfit(grades);
        return new TotalResult(totalWinnings, totalProfit);
    }

    private static void addWinning(Map<LottoGrade, Integer> totalWinnings, LottoGrade grade) {
        if (totalWinnings.containsKey(grade)) {
            totalWinnings.put(grade, totalWinnings.get(grade) + 1);
            return;
        }
        totalWinnings.put(grade, 1);
    }

    private static Money calculateTotalProfit(List<LottoGrade> grades) {
        return grades.stream()
                .map(Money::of)
                .reduce(Money::add)
                .orElse(Money.NO_MONEY);
    }

    public Money getTotalProfit() {
        return totalProfit;
    }

    public Integer getCount(LottoGrade grade) {
        return totalWinnings.getOrDefault(grade, 0);
    }
}
