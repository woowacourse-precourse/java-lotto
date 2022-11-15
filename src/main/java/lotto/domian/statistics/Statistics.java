package lotto.domian.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private static final double POINT_ONE = 0.1;
    private static final double DOUBLE_TEN = 10.0;
    private static final int ZERO = 0;
    private static final int INCREASE_BY_ONE = 1;
    private static final int INT_TEN = 10;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Statistics(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Integer, Integer> getNumberOfEachGrade(List<List<Integer>> lottosNumber) {
        List<Prize> grades = getEachLottoGrade(lottosNumber);
        return countEachGrade(grades);
    }

    public double getProfit(List<List<Integer>> lottosNumber) {
        double prizePercentage = (double) getTotalPrize(lottosNumber) / lottosNumber.size() * POINT_ONE;
        return Math.round(prizePercentage * INT_TEN) / DOUBLE_TEN;
    }

    private int getTotalPrize(List<List<Integer>> lottosNumber) {
        int totalPrize = ZERO;
        List<Prize> grades = getEachLottoGrade(lottosNumber);
        for (Prize grade : grades) {
            totalPrize += Prize.getPrice(grade);
        }
        return totalPrize;
    }

    private List<Prize> getEachLottoGrade(List<List<Integer>> lottosNumber) {
        List<Prize> grades = new ArrayList<>();
        Grade grade = new Grade(winningNumbers, bonusNumber);

        for (List<Integer> numbers : lottosNumber) {
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
                numberOfGrades.put(gradeNum, numberOfGrades.get(gradeNum) + INCREASE_BY_ONE);
                continue;
            }
            numberOfGrades.put(gradeNum, INCREASE_BY_ONE);
        }
        return numberOfGrades;
    }
}
