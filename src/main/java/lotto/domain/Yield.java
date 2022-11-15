package lotto.domain;

import java.util.List;

public class Yield {
    private final List<Grade> grades;
    private final int totalInvestment;

    public Yield(List<Grade> grades, int totalInvestment) {
        this.grades = grades;
        this.totalInvestment = totalInvestment;
    }

    public long getTotalWinningPrice() {
        long totalWinningPrice = 0;
        for(Grade grade: grades) {
            totalWinningPrice += grade.getPrizeMoney();
        }
        return totalWinningPrice;
    }

    public String getYield() {
        double percent = getTotalWinningPrice() * 100 / (double) totalInvestment;
        return String.format("%.1f%%", percent);
    }
}
