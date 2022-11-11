package lotto.output;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusBallCaseCheck;

public class WinningStatistics {

    public List<Integer> countCheck(List<Integer> number, List<Integer> bonusNumber) {
        BonusBallCaseCheck bonusBallCaseCheck = new BonusBallCaseCheck();

        List<Integer> statistics = new ArrayList<>();

        for (int i = 3; i <= 6; i++) {
            int check = 0;
            int result = 0;
            int winningNumber = 0;
            boolean flag = false;

            for (int crrent : number) {

                if (crrent == i) {
                    result++;
                }

                if (i == 5 && bonusNumber.get(check) == 1) {
                    winningNumber++;
                    flag = true;
                }

                check++;
            } // for문 끝

            if (flag == false) {
                statistics.add(result);
            }

            if (flag == true) {
                statistics.add(0);
                statistics.add(winningNumber);
                flag = false;
            }

            if (i == 5 && statistics.size() == 3) {
                statistics.add(0);
            }
        }

        return statistics;
    }
}
