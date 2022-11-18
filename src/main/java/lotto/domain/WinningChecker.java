package lotto.domain;

import java.util.List;

public class WinningChecker {
    private static final String nullMessage = "null";

    public static String check(List<Integer> winningNumber, int bonusNumber, List<Integer> expectedNumber) {
        return checkGrade(checkNumbers(winningNumber, bonusNumber, expectedNumber));
    }

    private static int[] checkNumbers(List<Integer> winningNumber, int bonusNumber, List<Integer> expectedNumber) {
        int[] grade = new int[2]; // 0: 일치하는 수의 갯수, 1: 보너스 번호 일치여부

        for (int number : winningNumber) {
            if (expectedNumber.contains(number)) {
                grade[0]++;
            }
        }
        if (expectedNumber.contains(bonusNumber)) {
            grade[1]++;
        }

        return grade;
    }

    private static String checkGrade(int[] grade) {
        Policy.WinningCriteria winning = Policy.WinningCriteria.find(grade);
        if (winning == null) {
            return nullMessage;
        }
        return winning.name();
    }
}
