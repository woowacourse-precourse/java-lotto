package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private final Purchase purchase;
    private final Winning winning;
    private final Map<Integer, Integer> winningGradeStat;
    private final double yield;

    public Statistic(Purchase purchase, Winning winning) {
        this.purchase = purchase;
        this.winning = winning;
        winningGradeStat = calculateWinningGradeStatistic();
        yield = calculateYield();
    }

    public Map<Integer, Integer> getWinningGradeStat() {
        return winningGradeStat;
    }

    public double getYield() {
        return yield;
    }

    public Map<Integer, Integer> calculateWinningGradeStatistic() {
        Map<Integer, Integer> winningStatistic = new HashMap<>();

        List<Integer> gradeResults = winningGradeResults();
        gradeResults.stream().filter(x -> x > 0)
                .forEach(x -> winningStatistic.put(x, winningStatistic.getOrDefault(x, 0)+1));
        return winningStatistic;
    }

    public List<Integer> winningGradeResults() {
        List<Integer> results = new ArrayList<>();
        for (Lotto purchasedLotto : purchase.getLotteries()) {
            int gradeResult = winningGrade(purchasedLotto);
            results.add(gradeResult);
        }
        return results;
    }

    public int winningGrade(final Lotto purchasedLotto) {
        int correspondantCountResult = calculateCorrespondNumberCount(purchasedLotto);
        int bonusNumber = this.winning.getBonusNumber();

        if (correspondantCountResult == 6) return 1;
        if (correspondantCountResult == 5 && purchasedLotto.getNumbers().contains(bonusNumber)) return 2;
        if (correspondantCountResult == 5) return 3;
        if (correspondantCountResult == 4) return 4;
        if (correspondantCountResult == 3) return 5;
        return 0;
    }

    public int calculateCorrespondNumberCount(final Lotto purchasedLotto) {
        return (int)purchasedLotto.getNumbers().stream()
                .filter(winning.getWinningNumbers()::contains).count();
    }

    public double calculateYield() {
        long sum = 0;
        for (int winningGrade : this.winningGradeStat.keySet()) {
            long winningReward = gradeToRewardMapping(winningGrade);
            sum += (winningReward * this.winningGradeStat.get(winningGrade));
        }
        return sum / (double)purchase.getPurchaseAmount();
    }

    public long gradeToRewardMapping(int winningGrade) {
        for (Grade x : Grade.values()) {
            if (x.getGrade() == winningGrade) {
                return x.getReward();
            }
        }
        return 0;
    }

    public void printWinningStatisticResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Grade grade : Grade.values()) {
            int count = winningGradeStat.getOrDefault(grade.getGrade(), 0);
            System.out.println(grade.getResult() + count + "개");
        }
        String format = String.format("총 수익률은 %.1f%%입니다.", this.yield * 100);
        System.out.println(format);
    }
}
