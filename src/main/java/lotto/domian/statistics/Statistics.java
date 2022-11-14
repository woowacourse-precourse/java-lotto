package lotto.domian.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Statistics(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Integer, Integer> getNumberOfEachGrade(List<List<Integer>> lottosNumber) {
        List<Prize> grades = getEachLottoGrade(lottosNumber);
        Map<Integer, Integer> numberOfGrades = countEachGrade(grades);
        return numberOfGrades;
    }

    public double getProfit(List<List<Integer>> lottosNumber) {
        double prizePercentage = (double) getTotalPrize(lottosNumber) / lottosNumber.size() * 0.1;
        return Math.round(prizePercentage * 10) / 10.0;
    }

    private int getTotalPrize(List<List<Integer>> lottosNumber) {
        int totalPrize = 0;
        List<Prize> grades = getEachLottoGrade(lottosNumber);
        for (Prize grade : grades) {
            totalPrize += Prize.getPrice(grade);
        }
        return totalPrize;
    }

    private List<Prize> getEachLottoGrade(List<List<Integer>> lottosNumber) {
        List<Prize> grades = new ArrayList<>();
        Grade grade = new Grade(winningNumbers, bonusNumber);

        for (List numbers : lottosNumber) {
            Prize eachGrade = grade.returnLottoGrade(numbers);
            if (eachGrade != null) {
                grades.add(eachGrade);
            }
        }
        return grades;
    }

    private Map<Integer, Integer> countEachGrade(List<Prize> grades) {
        Map<Integer, Integer> numberOfGrades = new HashMap<Integer, Integer>();

        for (Prize grade : grades) {
            int gradeNum = Prize.getGradeNum(grade);
            if (numberOfGrades.containsKey(gradeNum)) {
                numberOfGrades.put(gradeNum, numberOfGrades.get(gradeNum) + 1);
                continue;
            }
            numberOfGrades.put(gradeNum, 1);
        }
        return numberOfGrades;
    }
}
