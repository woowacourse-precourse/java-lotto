package lotto.domain;

import java.util.List;

public class WinningCounter {


    public int countWinningNormal(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int normalCount = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.subList(0, 6).contains(number)) {
                normalCount++;
            }
        }
        return normalCount;
    }

    public int countWinningBonus(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int bonusCount = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.get(6).equals(number)) {
                bonusCount++;
            }
        }
        return bonusCount;
    }
}
