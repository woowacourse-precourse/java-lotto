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
