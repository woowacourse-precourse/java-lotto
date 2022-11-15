package lotto.service;

import lotto.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsGenerateService {
    public Statistics generate(WinningNumbers winningNumbers, List<Lotto> lottos) {
        Map<Grade, Integer> gradeCount = countGrade(winningNumbers, lottos);
        float earningRate = calculateEarningRate(lottos.size(), gradeCount);

        return new Statistics(gradeCount, earningRate);
    }

    private Map<Grade, Integer> countGrade(WinningNumbers winningNumbers, List<Lotto> lottos) {
        Map<Grade, Integer> gradeCount = initializeGradeCount();

        for (Lotto lotto : lottos) {
            int count = (int) lotto.getNumbers()
                    .stream()
                    .filter(v -> winningNumbers.getNumbers().contains(v))
                    .count();
            Grade grade = getGrade(winningNumbers, lotto, count);
            gradeCount.put(grade, gradeCount.get(grade) + 1);
        }

        return gradeCount;
    }

    private Map<Grade, Integer> initializeGradeCount() {
        Map<Grade, Integer> gradeCount = new HashMap<>();

        for (Grade grade : Grade.values()) {
            gradeCount.put(grade, 0);
        }

        return gradeCount;
    }

    private Grade getGrade(WinningNumbers winningNumbers, Lotto lotto, int count) {
        if (count == Grade.SECOND.getMatchCount() && lotto.getNumbers().contains(winningNumbers.getBonus())) {
            return Grade.SECOND;
        }
        if (count == Grade.THIRD.getMatchCount() && !lotto.getNumbers().contains(winningNumbers.getBonus())) {
            return Grade.THIRD;
        }

        Grade[] grades = {Grade.FIRST, Grade.FOURTH, Grade.FIFTH};
        for (Grade grade : grades) {
            if (count == grade.getMatchCount()) {
                return grade;
            }
        }

        return Grade.NOTHING;
    }

    private float calculateEarningRate(int numberOfLotto, Map<Grade, Integer> gradeCount) {
        int earning = calculateEarning(gradeCount);
        int purchaseAmount = numberOfLotto * LottoSettings.LOTTO_PRICE;

        return (float) earning / purchaseAmount * 100;
    }

    private int calculateEarning(Map<Grade, Integer> gradeCount) {
        int earning = 0;

        for (Grade grade : Grade.values()) {
            int count = gradeCount.get(grade);
            if (count > 0) {
                earning += grade.getPrize() * count;
            }
        }

        return earning;
    }
}
