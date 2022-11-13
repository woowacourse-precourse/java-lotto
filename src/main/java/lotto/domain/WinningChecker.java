package lotto.domain;

import java.util.List;

public class WinningChecker {

    public static int check(List<Integer> winningNumber, int bonusNumber, List<Integer> expectedNumber) {
        return checkGrade(checkNumbers(winningNumber, bonusNumber, expectedNumber));
    }

    private static int[] checkNumbers(List<Integer> winningNumber, int bonusNumber, List<Integer> expectedNumber) {
        int[] grade = new int[2]; // 0: 일치하는 수의 갯수, 1: 보너스 번호 일치여부

        for(int number : winningNumber) {
            if(expectedNumber.contains(number)) {
                grade[0]++;
            }
        }
        if(expectedNumber.contains(bonusNumber)) {
            grade[1]++;
        }

        return grade;
    }

    private static int checkGrade(int[] grade) {
        if(grade[0] == 6) {
            return 1;
        }
        if(grade[0] == 5) {
            if(grade[1] == 1) {
                return 2;
            }
            return 3;
        }
        if(grade[0] == 4) {
            return 4;
        }
        if(grade[0] == 3) {
            return 5;
        }
        return 0;
    }
}
