package controller;

import java.util.ArrayList;
import java.util.List;

public class Compare {

    public static int compareWithWinningNumber(List<Integer> winningNumber, List<Integer> lottoNumber) {
        int hitCount = 0;
        for (int lottoNum : lottoNumber) {
            if (winningNumber.contains(lottoNum)) {
                hitCount++;
            }
        }
        return hitCount;
    }

    public static int compareWithBonusNumber(List<Integer> bonusNumber, List<Integer> lottoNumber) {
        int hitCount = 0;
        if (lottoNumber.contains(bonusNumber.get(0))) {
            hitCount++;
        }
        return hitCount;
    }

    public static List<Integer> getWinningCount(
            List<Integer> winningNumber,
            List<Integer> bonusNumber,
            List<Integer> lottoNumber) {
        List<Integer> winningCount = new ArrayList<>();
        winningCount.add(compareWithWinningNumber(winningNumber,lottoNumber));
        winningCount.add(compareWithBonusNumber(bonusNumber,lottoNumber));
        return winningCount;
    }
}
